//
//  PitchingHistoryDataSource.swift
//  baseball
//
//  Created by user on 2021/05/06.
//

import UIKit

class PitchingHistoryDataSource {

    private var dataSource: UITableViewDiffableDataSource<String, String>!
    
    func setupDataSource(tableView: UITableView) -> Void {
        self.dataSource = UITableViewDiffableDataSource<String, String>(tableView: tableView, cellProvider: { (tableView, indexPath, string) -> UITableViewCell? in
            let cell = tableView.dequeueReusableCell(withIdentifier: "testcell") as! testCell
            cell.test1.text = string
            return cell
        })
        var snapshot = self.dataSource.snapshot()
        snapshot.appendSections(["1"])
        self.dataSource.apply(snapshot)
    }
    
    func applySnapshot(string: String) {
        var snapshot = self.dataSource.snapshot()
        let items = snapshot.itemIdentifiers(inSection: "1")
        if items.count == 0 {
            snapshot.appendItems([string], toSection: "1")
        } else {
            snapshot.insertItems([string], beforeItem: items[0])
        }
        
        self.dataSource.apply(snapshot)
    }
}
