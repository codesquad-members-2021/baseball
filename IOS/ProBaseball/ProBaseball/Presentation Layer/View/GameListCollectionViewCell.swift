//
//  GameListCollectionViewCell.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import UIKit

class GameListCollectionViewCell: UICollectionViewCell {
    @IBOutlet weak var gameNumberLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        homeTeamLabel.font = UIFont(name: "AmericanCaptain", size: 50)
        awayTeamLabel.font = UIFont(name: "AmericanCaptain", size: 50)
    }
}
