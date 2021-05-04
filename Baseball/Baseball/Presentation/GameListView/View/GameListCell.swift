//
//  GameListCell.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/04.
//

import UIKit

class GameListCell: UICollectionViewCell {
    
    @IBOutlet weak var gameNumberLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    
    
    func configure(game: MatchUp) {
        gameNumberLabel.text = "Game"+"\(game.matchNumber)"
        awayTeamLabel.text = game.awayTeam
        homeTeamLabel.text = game.homeTeam
    }
}
