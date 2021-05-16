//
//  ViewController.swift
//  baseball-game
//
//  Created by Song on 2021/05/03.
//

import UIKit
import Combine

enum TeamSide: String, Codable {
    case home
    case away
}

class GamePlayViewController: UIViewController {

    @IBOutlet weak var pitchListTableView: UITableView!
    @IBOutlet weak var pitchButton: UIButton!
    @IBOutlet weak var teamScoreView: TeamScoreView!
    @IBOutlet weak var inningLabel: UILabel!
    @IBOutlet weak var turnLabel: UILabel!
    @IBOutlet weak var pitcherInfoView: PitcherInfoView!
    @IBOutlet weak var batterInfoView: PitcherInfoView!
    @IBOutlet weak var ballCountView: BallCountView!
    @IBOutlet weak var groundView: GroundView!

    enum ViewID {
        static let storyboard = "GamePlay"
        static let segue = "selectPitcher"
    }
    
    private var gamePlayViewModel: GamePlayViewModel!
    private var dataSource: UITableViewDiffableDataSource<Int, Pitch>!

    private let userTeamSide = TeamSide.home
    private var gameInfo: GameInfo!
    private var cancelBag = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gamePlayViewModel = GamePlayViewModel(userTeamSide)
        self.pitchButton.isHidden = true
        gamePlayViewModel.requestGame()
        configureDataSource()
        bind()
        addNotifications()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        ballCountView.configure()
        groundView.configure()
        ballCountView.reset()
    }
    
    @IBAction func pitchButtonTouched(_ sender: Any) {
        gamePlayViewModel.requestPitch()
    }
    
    @IBAction func pitcherChangeTouched(_ sender: Any) {
        performSegue(withIdentifier: ViewID.segue, sender: nil)
    }

}


extension GamePlayViewController {
    
    private func bind() {
        gamePlayViewModel.$gameUpdator
            .receive(on: DispatchQueue.main)
            .sink { [weak self] gameUpdator in
                guard let gameUpdator = gameUpdator else { return }
                self?.updateViews(with: gameUpdator)
            }
            .store(in: &cancelBag)
        
        gamePlayViewModel.$pitchList
            .receive(on: DispatchQueue.main)
            .sink { [weak self] pitches in
                guard let pitches = pitches else { return }
                self?.createSnapshot(from: pitches)
            }
            .store(in: &cancelBag)
        
        gamePlayViewModel.$error
            .receive(on: DispatchQueue.main)
            .sink { error in
                guard let error = error else { return }
                print(error) ///사용자에게 에러 표시하는 부분 미구현
            }.store(in: &cancelBag)
        
        gamePlayViewModel.$alertMessage
            .receive(on: DispatchQueue.main)
            .sink { message in
                guard let message = message else { return }
                let alert = AlertFactory.create(with: message)
                self.present(alert, animated: true, completion: nil)
            }.store(in: &cancelBag)
    }
    
    private func updateViews(with gameManager: GameInformable) {
        teamScoreView.updateTeamNames(from: gameManager.teamInfo())
        teamScoreView.updateScores(from: gameManager.scoreInfo())
        inningLabel.text = gameManager.inningInfo()
        pitcherInfoView.updateLabels(from: gameManager.pitcherInfo())
        batterInfoView.updateLabels(from: gameManager.batterInfo())
        
        guard let isUserDefense = gameManager.isUserDefense() else { return }
        
        if isUserDefense {
            self.pitchButton.isHidden = false
            turnLabel.text = GameManager.Role.defense
            pitcherInfoView.highlight()
            batterInfoView.unhighlight()
        } else {
            self.pitchButton.isHidden = true
            turnLabel.text = GameManager.Role.offense
            pitcherInfoView.unhighlight()
            batterInfoView.highlight()
        }
    }
    
    private func addNotifications() {
        NotificationCenter.default
            .publisher(for: BallCounter.notiName)
            .sink { data in
                guard let ballType = data.userInfo?[BallCounter.UserInfo.ballType] as? BallCount,
                      let count = data.userInfo?[BallCounter.UserInfo.count] as? Int else { return }
                DispatchQueue.main.async {
                    switch ballType {
                    case .strike:
                        self.ballCountView.fillStrike(upto: count)
                    case .ball:
                        self.ballCountView.fillBall(upto: count)
                    case .out:
                        self.ballCountView.fillOut(upto: count)
                    }
                }
            }.store(in: &cancelBag)
        
        NotificationCenter.default
            .publisher(for: BaseManager.notiName)
            .sink { data in
                guard let movementType = data.userInfo?[BaseManager.UserInfo.movement] as? BaseMovement else { return }
                DispatchQueue.main.sync {
                    switch movementType {
                    case .homeToFirst:
                        self.groundView.homeTofirstBase()
                    case .firstToSecond:
                        self.groundView.firstBaseToSecondBase()
                    case .secondToThird:
                        self.groundView.secondBaseToThirdBase()
                    case .thirdToHome:
                        self.groundView.thirdBaseToHome()
                    case .reset:
                        self.groundView.reset()
                    }
                }
            }.store(in: &cancelBag)
    }
}


extension GamePlayViewController {
    
    private func configureDataSource() {
        self.dataSource = UITableViewDiffableDataSource.init(tableView: pitchListTableView) {
            [weak self] (tableView, indexPath, pitch) -> UITableViewCell in
            
            guard let self = self,
                  let cell = self.pitchListTableView.dequeueReusableCell(withIdentifier: PitchListTableViewCell.reuseIdentifier) as? PitchListTableViewCell else {
                return PitchListTableViewCell()
            }
            cell.updateLabels(count: pitch.count, result: pitch.result, log: pitch.log)
            
            return cell
        }
    }
    
    private func createSnapshot(from pitches: [Pitch]) {
        var snapshot = NSDiffableDataSourceSnapshot<Int, Pitch>()
        
        snapshot.appendSections([0])
        snapshot.appendItems(pitches, toSection: 0)
        self.dataSource.apply(snapshot)
    }
    
}


extension GamePlayViewController: Instantiatable, IdentifierReusable {
    
    static func instantiate() -> UIViewController {
        let myViewController = UIStoryboard(name: ViewID.storyboard, bundle: nil).instantiateViewController(withIdentifier: self.reuseIdentifier) as? GamePlayViewController
        
        return myViewController ?? GamePlayViewController()
    }
    
}


extension GamePlayViewController {
    
    func getInfo(with gameInfo: GameInfo) {
        self.gameInfo = gameInfo
    }
    
}
