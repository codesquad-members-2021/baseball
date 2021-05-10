//
//  GameViewController.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import UIKit
import SnapKit

enum Section {
    case main
}

struct Foo: Hashable {
    static func == (lhs: Foo, rhs: Foo) -> Bool {
        return lhs.title == rhs.title
    }
    
    let title: String
}

fileprivate typealias Datasource = UITableViewDiffableDataSource<Section, Foo>
fileprivate typealias Snapshot = NSDiffableDataSourceSnapshot<Section, Foo>

final class GameViewController: UIViewController {
    
    @IBOutlet weak var gameView: GameView!
    @IBOutlet weak var ballCount: UITableView!
    @IBOutlet var tableViewHeight: NSLayoutConstraint!
    private lazy var dataSource = makeDataSource()
    var foos: [Foo] = [Foo(title: "aa")]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        registerNib()
        applySnapshot()
        configureTableViewHeight()
        appearPitchButton()
    }
    
    private func configureTableViewHeight() {
        DispatchQueue.main.async {
            self.tableViewHeight.constant = self.ballCount.contentSize.height
        }
    }
    
    private func registerNib() {
        let nibName = UINib(nibName: "GameStoryTableViewCell", bundle: nil)
        ballCount.register(nibName, forCellReuseIdentifier: GameStoryTableViewCell.className)
    }
    
    private func makeDataSource() -> Datasource {
        let dataSource = Datasource(tableView: ballCount) { (tableView, indexPath, item) -> UITableViewCell? in
            let cell = tableView.dequeueReusableCell(withIdentifier: GameStoryTableViewCell.className, for: indexPath) as? GameStoryTableViewCell
            cell?.countLabel.text = "스트라이크"
            cell?.countImage.image = UIImage(systemName: "doc.fill")
            return cell
        }
        return dataSource
    }
    
    private func applySnapshot(animatingDifferences: Bool = true) {
        var snapshot = Snapshot()
        snapshot.appendSections([.main])
        snapshot.appendItems(foos, toSection: .main)
        dataSource.apply(snapshot, animatingDifferences: animatingDifferences)
    }
    
    private func appearPitchButton() {
        let pitchButton = PitchButton()
        self.gameView.addSubview(pitchButton)
        pitchButton.snp.makeConstraints {
            $0.centerX.centerY.equalTo(self.gameView.safeAreaLayoutGuide)
            $0.width.equalTo(120)
            $0.height.equalTo(30)
        }
        
    }
}

