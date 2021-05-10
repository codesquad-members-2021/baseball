//
//  CurrentPlayerView.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class CurrentPlayerView: UIView {
    @IBOutlet weak var pitcher: UILabel!
    @IBOutlet weak var pitcherStatus: UILabel!
    @IBOutlet weak var isPitcher: UIImageView!
    @IBOutlet weak var batter: UILabel!
    @IBOutlet weak var batterStatus: UILabel!
    @IBOutlet weak var isBatter: UIImageView!
    
    enum Role {
        static let DEFENSE = "DEFENSE"
    }
    
    func configure(pitcher: Player, status: String) {
        self.pitcher.text = pitcher.name
        self.pitcherStatus.text = status
    }
    
    func configure(batter: Player, status: String) {
        self.batter.text = batter.name
        self.batterStatus.text = status
    }
    
    func configure(playerRole: String) {
        if playerRole == Role.DEFENSE {
            isBatter.isHidden = false
            isPitcher.isHidden = true
        } else {
            isBatter.isHidden = true
            isPitcher.isHidden = false
        }
    }
}
