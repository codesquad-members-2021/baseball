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

    enum ViewID {
        static let storyboard = "GamePlay"
        static let controller = "gamePlay"
        static let segue = "selectPitcher"
        static let cell = "pitchListCell"
    }
    
    enum Role {
        static let offense = "offense"
        static let defense = "defense"
    }
    
    private var gamePlayViewModel: GamePlayViewModel!
    private var dataSource: UITableViewDiffableDataSource<Int, Pitch>!

    private let isUserHomeSide = true // 게임 선택 시 값을 지정해줄 수 있도록 한다 (prepare segue?)
    private var cancelBag = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gamePlayViewModel = GamePlayViewModel(isUserHomeSide)
        self.pitchButton.isHidden = true
        gamePlayViewModel.requestGame()
        configureDataSource()
        bind()
    }
    
    private func bind() {
        gamePlayViewModel.$gameManager
            .receive(on: DispatchQueue.main)
            .sink { [weak self] gameManager in
                guard let gameManager = gameManager else { return }
                self?.updateLabels(with: gameManager)
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
                print(error) //사용자에게 에러 표시!
            }.store(in: &cancelBag)
    }

    @IBAction func pitcherChangeTouched(_ sender: Any) {
        performSegue(withIdentifier: ViewID.segue, sender: nil)
    }
    
    //정리가 필요하다.
    @IBOutlet weak var homeLabel: UILabel!
    @IBOutlet weak var homeScoreLabel: UILabel!
    
    @IBOutlet weak var awayLabel: UILabel!
    @IBOutlet weak var awayScoreLabel: UILabel!
    
    @IBOutlet weak var inningLabel: UILabel!
    @IBOutlet weak var turnLabel: UILabel!
    
    @IBOutlet weak var pitcherView: UIView!
    @IBOutlet weak var pitcherNameLabel: UILabel!
    @IBOutlet weak var pitherInfoLabel: UILabel!
    
    @IBOutlet weak var batterView: UIView!
    @IBOutlet weak var batterNameLabel: UILabel!
    @IBOutlet weak var batterInfoLabel: UILabel!
    
    
    private func updateLabels(with gameManager: GameManagable) {
        let teamInfo = gameManager.teams()
        homeLabel.text = teamInfo[GameManager.Side.home]!
        awayLabel.text = teamInfo[GameManager.Side.away]!
        
        let scoreInfo = gameManager.scores()
        homeScoreLabel.text = "\(scoreInfo[GameManager.Side.home]!)"
        awayScoreLabel.text = "\(scoreInfo[GameManager.Side.away]!)"
        
        inningLabel.text = gameManager.inning()
        
        let pitcherInfo = gameManager.pitcher()
        pitcherNameLabel.text = pitcherInfo.name
        pitherInfoLabel.text = pitcherInfo.info
        
        let batterInfo = gameManager.batter()
        batterNameLabel.text = batterInfo.name
        batterInfoLabel.text = batterInfo.info
        
        guard let isUserDefense = gameManager.isUserDefense() else { return }
        
        if isUserDefense {
            self.pitchButton.isHidden = false
            pitcherView.backgroundColor = .lightGray
            batterView.backgroundColor = .white
        } else {
            self.pitchButton.isHidden = true
            pitcherView.backgroundColor = .white
            batterView.backgroundColor = .lightGray
        }
    }
}

extension GamePlayViewController {
    
    private func configureDataSource() {
        self.dataSource = UITableViewDiffableDataSource.init(tableView: pitchListTableView) { (tableView, indexPath, pitch) -> UITableViewCell in
            
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
