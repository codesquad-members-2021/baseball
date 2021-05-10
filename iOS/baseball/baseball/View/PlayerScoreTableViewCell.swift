//
//  PlayerScoreTableViewCell.swift
//  baseball
//
//  Created by Issac on 2021/05/05.
//

import UIKit

class PlayerScoreTableViewCell: UITableViewCell {
    @IBOutlet weak var playerName: UILabel!
    @IBOutlet weak var TPA: UILabel!
    @IBOutlet weak var hits: UILabel!
    @IBOutlet weak var out: UILabel!
    @IBOutlet weak var AVG: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
//        self.AVG.text =
    }
    
    func configure(playerScoreBoard: PlayerScoreBoard) {
        self.playerName.text = playerScoreBoard.name
        self.TPA.text = "\(playerScoreBoard.TPA)"
        self.hits.text = "\(playerScoreBoard.hits)"
        self.out.text = "\(playerScoreBoard.out)"
    }
}
