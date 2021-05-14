//
//  GameCell.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import UIKit

class GameCell: UITableViewCell, IdentifierReusable {
    
    static let nib = UINib(nibName: GameCell.reuseIdentifier, bundle: nil)
    
    @Published var userTeam: String!
    
    @IBOutlet weak var gameIdLabel: UILabel!
    @IBOutlet weak var awayTeamButton: UIButton!
    @IBOutlet weak var homeTeamButton: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
}


extension GameCell {

    func updateUI(with viewModel: SelectViewModel) {
        guard let model = viewModel.gameSelectInfo else { return }
        
        self.gameIdLabel.text = model.gameID
        self.awayTeamButton.setTitle(model.away, for: .normal)
        self.homeTeamButton.setTitle(model.home, for: .normal)
        
        self.awayTeamButton.isEnabled = model.isAwayEnable
        self.homeTeamButton.isEnabled = model.isHomeEnable
    }
    
    @IBAction func awayButtonTouched(_ sender: UIButton) {
        self.userTeam = sender.currentTitle
        self.awayTeamButton.isEnabled = false
    }
    
    @IBAction func homeButtonTouched(_ sender: UIButton) {
        self.userTeam = sender.currentTitle
        self.homeTeamButton.isEnabled = false
    }
    
}
