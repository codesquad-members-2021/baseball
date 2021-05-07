//
//  InGameViewController.swift
//  baseball
//
//  Created by 박정하 on 2021/05/04.
//

import UIKit

class InGameViewController: UIViewController {
    
    @IBOutlet weak var pitchingHistoryTableView: UITableView!
    @IBOutlet weak var inningInfoView: InningInfoView!
    
    private var dataSource = PitchingHistoryDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        dataSource.setupDataSource(tableView: pitchingHistoryTableView)
        self.inningInfoView.applyBallCount(strike: 1, ball: 2, out: 1)
    }
}

