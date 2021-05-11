//
//  GameListCell.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/04.
//

import UIKit

class GameListCell: UICollectionViewCell {
    
    @IBOutlet weak var gameCountLabel: UILabel!
    @IBOutlet weak var awayTeamNameLabel: UILabel!
    @IBOutlet weak var homeTeamNameLabel: UILabel!
    static let identifier = "GameListCell"
    
    override func awakeFromNib() {
        super.awakeFromNib()
        self.awayTeamNameLabel.text = "Rockets"
    }
    
    static var nib: UINib {
        return UINib(nibName: identifier, bundle: nil)
    }
    
    var gameList: GameList? {
        didSet{
            self.gameCountLabel.text = "\(gameList?.gameNumber)"
            self.awayTeamNameLabel.text = gameList?.away
            self.homeTeamNameLabel.text = gameList?.home
        }
    }
}
