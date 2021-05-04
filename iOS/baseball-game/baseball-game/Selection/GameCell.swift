//
//  GameCell.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import UIKit

class GameCell: UITableViewCell {
    static let reuseIdentifier = "GameCell"
    static let nib = UINib(nibName: GameCell.reuseIdentifier, bundle: nil)
    
    @IBOutlet weak var gameIdLabel: UILabel!
    @IBOutlet weak var awayTeamButton: UIButton!
    @IBOutlet weak var homeTeamButton: UIButton!
    
    private var awayTeam: String!
    private var homeTeam: String!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    func fill(state: Game) {
        self.gameIdLabel.text = "GAME \(state.id)"
        self.awayTeamButton.setTitle(state.away, for: .normal)
        self.homeTeamButton.setTitle(state.home, for: .normal)
        
        self.awayTeam = state.away
        self.homeTeam = state.home
    }
    
}
