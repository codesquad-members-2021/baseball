//
//  ViewController.swift
//  baseball-game
//
//  Created by Song on 2021/05/03.
//

import UIKit
import Combine

class GamePlayViewController: UIViewController {

    @IBOutlet weak var pitchListTableView: UITableView!
    @IBOutlet weak var pitchButton: UIButton!
    @IBOutlet weak var teamScoreView: TeamScoreView!
    @IBOutlet weak var inningLabel: UILabel!
    @IBOutlet weak var turnLabel: UILabel!
    @IBOutlet weak var pitcherInfoView: PitcherInfoView!
    @IBOutlet weak var batterInfoView: PitcherInfoView!

    enum ViewID {
        static let storyboard = "GamePlay"
        static let controller = "gamePlay"
        static let segue = "selectPitcher"
        static let cell = "pitchListCell"
    }
    
    private var gamePlayViewModel: GamePlayViewModel!
    private var dataSource: UITableViewDiffableDataSource<Int, Pitch>!

    private let isUserHomeSide = true
    private var cancelBag = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gamePlayViewModel = GamePlayViewModel(isUserHomeSide)
        self.pitchButton.isHidden = true
        gamePlayViewModel.requestGame()
        configureDataSource()
        bind()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        ballCountView.configure()
        groundView.configure()
        
        //ballCountView.reset()
        
        //애니메이션 test
        DispatchQueue.main.asyncAfter(deadline: .now() + 1) {
            self.groundView.homeTofirstBase()
        }
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 5) {
            self.groundView.firstBaseToSecondBase()
        }
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 9) {
            self.groundView.secondBaseToThirdBase()
        }
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 14) {
            self.groundView.thirdBaseToHome()
        }
    }
    
    @IBOutlet weak var ballCountView: BallCountView!
    @IBOutlet weak var groundView: GroundView!
    
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
            
            guard let cell = self.pitchListTableView.dequeueReusableCell(withIdentifier: ViewID.cell) as? PitchListTableViewCell else {
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
