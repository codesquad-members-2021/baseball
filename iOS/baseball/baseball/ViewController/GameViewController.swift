//
//  GameViewController.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import UIKit

enum Section {
    case main
}

struct Foo: Hashable {
    static func == (lhs: Foo, rhs: Foo) -> Bool {
        return lhs.title == rhs.title
    }
    
    let title: String
}

typealias Datasource = UITableViewDiffableDataSource<Section, Foo>
typealias Snapshot = NSDiffableDataSourceSnapshot<Section, Foo>

class GameViewController: UIViewController {
    
    @IBOutlet weak var gameStory: UITableView!
    private lazy var dataSource = makeDataSource()
    var foos: [Foo] = [Foo(title: "aa"), Foo(title: "dd")]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        registerNib()
        applySnapshot()
    }
    
    func registerNib() {
        let nibName = UINib(nibName: "GameStoryTableViewCell", bundle: nil)
        gameStory.register(nibName, forCellReuseIdentifier: GameStoryTableViewCell.identifier)
    }
    
    func makeDataSource() -> Datasource {
        let dataSource = Datasource(tableView: gameStory) { (tableView, indexPath, item) -> UITableViewCell? in
            let cell = tableView.dequeueReusableCell(withIdentifier: GameStoryTableViewCell.identifier, for: indexPath) as? GameStoryTableViewCell
            cell?.countLabel.text = item.title
            return cell
        }
        return dataSource
    }
    
    func applySnapshot(animatingDifferences: Bool = true) {
        var snapshot = Snapshot()
        snapshot.appendSections([.main])
        snapshot.appendItems(foos, toSection: .main)
        dataSource.apply(snapshot, animatingDifferences: animatingDifferences)
    }
}
