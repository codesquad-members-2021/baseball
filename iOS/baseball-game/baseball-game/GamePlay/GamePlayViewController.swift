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
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        ballCountView.configure()
        groundView.configure()
        
        ballCountView.reset()
    }

}


extension GamePlayViewController {
    
    private func bind() {
        gamePlayViewModel.$gameManager
            .receive(on: DispatchQueue.main)
            .sink { [weak self] gameManager in
                guard let gameManager = gameManager else { return }
                self?.updateViews(with: gameManager)
            }
            .store(in: &cancelBag)
        
        gamePlayViewModel.$pitches
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
    }

    @IBAction func pitcherChangeTouched(_ sender: Any) {
        performSegue(withIdentifier: ViewID.segue, sender: nil)
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
    
}


extension GamePlayViewController {
    
    private func configureDataSource() {
        self.dataSource = UITableViewDiffableDataSource.init(tableView: pitchListTableView) {
            (tableView, indexPath, pitch) -> UITableViewCell in
            
            guard let cell = self.pitchListTableView.dequeueReusableCell(withIdentifier: PitchListTableViewCell.reuseIdentifier) as? PitchListTableViewCell else {
                return PitchListTableViewCell()
            }
            
            let index = indexPath.row
            cell.updateLabels(count: index, result: pitch.result, log: pitch.log)
            
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
