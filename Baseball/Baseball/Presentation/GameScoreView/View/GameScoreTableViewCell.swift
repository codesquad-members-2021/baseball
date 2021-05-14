//
//  GameScoreTableViewCell.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit

class GameScoreTableViewCell: UITableViewCell {

    @IBOutlet weak var playerNameLabel: UILabel!
    @IBOutlet weak var uniformNumberLabel: UILabel!
    @IBOutlet weak var playedGamesLabel: UILabel!
    @IBOutlet weak var atBatLabel: UILabel!
    @IBOutlet weak var hitLabel: UILabel!
    @IBOutlet weak var strikeLabel: UILabel!
    @IBOutlet weak var ballLabel: UILabel!
    @IBOutlet weak var averageLabel: UILabel!
    
    func configure(playerRecord: PlayerRecord) {
        playerNameLabel.text = playerRecord.name
        uniformNumberLabel.text = String(playerRecord.uniformNumber)
        playedGamesLabel.text = String(playerRecord.playerGames)
        atBatLabel.text = String(playerRecord.atBat)
        hitLabel.text = String(playerRecord.hit)
        strikeLabel.text = String(playerRecord.strike)
        ballLabel.text = String(playerRecord.ball)
        averageLabel.text = String(format: "%.3f", playerRecord.battingAverage)
    }
    
}
