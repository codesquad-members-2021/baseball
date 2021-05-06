//
//  GameCell.swift
//  baseballApp
//
//  Created by 김지선 on 2021/05/06.
//

import UIKit

class GameCell: UICollectionViewCell {
    

    @IBOutlet weak var gameIdLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    func configureCell(game: Game) {
        gameIdLabel.text = "Game \(game.id)"
        homeTeamLabel.text = game.home
        awayTeamLabel.text = game.away
        layer.masksToBounds = true
        layer.cornerRadius = 15
    }
}
