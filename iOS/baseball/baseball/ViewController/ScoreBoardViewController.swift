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
    @IBOutlet weak var tableViewHeight: NSLayoutConstraint!
    
    typealias DataSource = UITableViewDiffableDataSource<String, PlayerScoreBoard>
    typealias Snapshot = NSDiffableDataSourceSnapshot<String, PlayerScoreBoard>
    private lazy var dataSource = makeDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setTeamControllerBarTitle()
        self.tableViewCellRegisterNib()
        self.itemListDidLoad()
        self.tableViewHeight.constant = self.playerScoreTableView.contentSize.height
    }
    
    private func setTeamControllerBarTitle() {
        teamControllBar.setTitle("A~", forSegmentAt: 0)
        teamControllBar.setTitle("B~", forSegmentAt: 1)
    }
    
    private func tableViewCellRegisterNib() {
        let nib = UINib(nibName: PlayerScoreTableViewCell.identifier, bundle: nil)
        self.playerScoreTableView.register(nib, forCellReuseIdentifier: PlayerScoreTableViewCell.identifier)
        let headerNib = UINib(nibName: PlayerScoreHeaderTableViewCell.identifier, bundle: nil)
        self.playerScoreTableView.register(headerNib, forHeaderFooterViewReuseIdentifier: PlayerScoreHeaderTableViewCell.identifier)
        let footerNib = UINib(nibName: PlayerScoreFooterTableViewCell.identifier, bundle: nil)
        self.playerScoreTableView.register(footerNib, forHeaderFooterViewReuseIdentifier: PlayerScoreFooterTableViewCell.identifier)
    }
    
    private func itemListDidLoad() {
        var snapshot = Snapshot()
        let playerScoreBoards = [
            PlayerScoreBoard(id: 1, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 2, name: "정대현", TPA: 1, hits: 3, out: 1),
            PlayerScoreBoard(id: 3, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 4, name: "정대현", TPA: 1, hits: 3, out: 1),
            PlayerScoreBoard(id: 5, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 6, name: "정대현", TPA: 1, hits: 3, out: 1),
            PlayerScoreBoard(id: 7, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 8, name: "정대현", TPA: 1, hits: 3, out: 1),
            PlayerScoreBoard(id: 9, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 10, name: "정대현", TPA: 1, hits: 3, out: 1),
            PlayerScoreBoard(id: 11, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 12, name: "정대현", TPA: 1, hits: 3, out: 1),
            PlayerScoreBoard(id: 13, name: "양원종", TPA: 1, hits: 1, out: 2),
            PlayerScoreBoard(id: 14, name: "정대현", TPA: 1, hits: 3, out: 1),
        ]
        snapshot.appendSections(["test"])
        snapshot.appendItems(playerScoreBoards, toSection: "test")
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

extension ScoreBoardViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let header = Bundle.main.loadNibNamed(PlayerScoreHeaderTableViewCell.identifier, owner: self, options: nil)?.last as! PlayerScoreHeaderTableViewCell
        return header
    }
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let footer = Bundle.main.loadNibNamed(PlayerScoreFooterTableViewCell.identifier, owner: self, options: nil)?.last as! PlayerScoreFooterTableViewCell
        return footer
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 30
    }
    
    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        return 30
    }
}
