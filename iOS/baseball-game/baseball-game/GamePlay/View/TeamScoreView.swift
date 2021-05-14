//
//  TeamScoreView.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import UIKit

class TeamScoreView: UIView {

    @IBOutlet weak var homeTeamLabel: UILabel!
    @IBOutlet weak var homeScoreLabel: UILabel!
    
    @IBOutlet weak var awayTeamLabel: UILabel!
    @IBOutlet weak var awayScoreLabel: UILabel!
    
    func updateTeamNames(from names: [String: String]) {
        let homeName = names[GameManager.Side.home]!
        let awayName = names[GameManager.Side.away]!
        homeTeamLabel.text = homeName
        awayTeamLabel.text = awayName
    }
    
    func updateScores(from scores: [String: Int]) {
        let homeScore = scores[GameManager.Side.home]!
        let awayScore = scores[GameManager.Side.away]!
        homeScoreLabel.text = "\(homeScore)"
        awayScoreLabel.text = "\(awayScore)"
    }
    
}
