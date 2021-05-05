//
//  ScoreBoardViewController.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import UIKit

class ScoreBoardViewController: UIViewController {
    @IBOutlet weak var homeTotalScore: UILabel!
    @IBOutlet weak var awayTotalScore: UILabel!
    @IBOutlet var homeScores: [UILabel]!
    @IBOutlet var awayScores: [UILabel]!
    @IBOutlet weak var playerScoreTableView: UITableView!
    @IBOutlet weak var teamControllBar: UISegmentedControl!
    
    typealias DataSource = UITableViewDiffableDataSource<String, PlayerScoreBoard>
    typealias Snapshot = NSDiffableDataSourceSnapshot<String, PlayerScoreBoard>
    private lazy var dataSource = makeDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        teamControllBar.setTitle("A~", forSegmentAt: 0)
        teamControllBar.setTitle("B~", forSegmentAt: 1)
        self.tableViewCellRegisterNib()
        self.itemListDidLoad()
    }
    
    private func tableViewCellRegisterNib() {
        let nib = UINib(nibName: PlayerScoreTableViewCell.identifier, bundle: nil)
        self.playerScoreTableView.register(nib, forCellReuseIdentifier: PlayerScoreTableViewCell.identifier)
    }
    
    private func itemListDidLoad() {
        var snapshot = Snapshot()
        let playerScoreBoards = [
            PlayerScoreBoard(id: 1, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 2, name: "정대현", TPA: 1, hits: 3, out: 1)
        ]
        snapshot.appendSections(["test"])
        snapshot.appendItems(playerScoreBoards)
        dataSource.apply(snapshot)
    }
    
    private func makeDataSource() -> DataSource {
        return DataSource(tableView: self.playerScoreTableView) { (tableView, indexPath, playerScoreBoard) -> PlayerScoreTableViewCell? in
            guard let cell = tableView.dequeueReusableCell(withIdentifier: PlayerScoreTableViewCell.identifier, for: indexPath) as? PlayerScoreTableViewCell else { return PlayerScoreTableViewCell() }
            cell.configure(playerScoreBoard: playerScoreBoard)
            return cell
        }
    }
}

extension ScoreBoardViewController {
    private func sumScore(of scores: [UILabel]) -> String{
        return "\(scores.reduce(0, { $0 + (Int($1.text ?? "0") ?? 0)  }))"
    }
}
