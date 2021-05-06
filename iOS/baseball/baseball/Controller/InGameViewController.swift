//
//  InGameViewController.swift
//  baseball
//
//  Created by 박정하 on 2021/05/04.
//

import UIKit

class InGameViewController: UIViewController {
    
    @IBOutlet weak var pitchingHistoryTableView: UITableView!
    private var dataSource = PitchingHistoryDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        dataSource.setupDataSource(tableView: pitchingHistoryTableView)
        dataSource.applySnapshot(string: "두팔")
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        sleep(1)
        dataSource.applySnapshot(string: "곽")
        sleep(1)
        dataSource.applySnapshot(string: "두")
        sleep(1)
        dataSource.applySnapshot(string: "팔")
    }
}

