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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        teamControllBar.setTitle("A~", forSegmentAt: 0)
        teamControllBar.setTitle("B~", forSegmentAt: 1)
    }
}

extension ScoreBoardViewController {
    private func sumScore(of scores: [UILabel]) -> String{
        return "\(scores.reduce(0, { $0 + (Int($1.text ?? "0") ?? 0)  }))"
    }
}
