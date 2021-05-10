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
    
    private var viewModel: SelectViewModel!
    var delegate: GameCellDelegate!
    
    @IBOutlet weak var gameIdLabel: UILabel!
    @IBOutlet weak var awayTeamButton: UIButton!
    @IBOutlet weak var homeTeamButton: UIButton!
    
    private var gameInfo = GameInfo()
    private var awayTeam: String!
    private var homeTeam: String!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    func fill(_ viewModel: SelectViewModel, state: Game) {
        self.viewModel = viewModel
        self.gameInfo = GameInfo(userID: viewModel.gameInfo.userID, gameID: state.id)
        
        self.gameIdLabel.text = "GAME \(state.id)"
        self.awayTeamButton.setTitle(state.away.team, for: .normal)
        self.homeTeamButton.setTitle(state.home.team, for: .normal)
        self.setIsEnabled(state: state)
        
        self.awayTeam = state.away.team
        self.homeTeam = state.home.team
    }
    
    private func setIsEnabled(state: Game) {
        if state.away.status == "selected" { self.awayTeamButton.isEnabled = false }
        if state.home.status == "selected" { self.homeTeamButton.isEnabled = false }
    }
    
    @IBAction func awayButtonTouched(_ sender: UIButton) {
        self.gameInfo.team = self.awayTeam
        self.viewModel.setModel(with: self.gameInfo)
        self.viewModel.postSelection(with: self.gameInfo)
        self.awayTeamButton.isEnabled = false
        
        self.delegate.didPressButton(with: self.gameInfo)
    }
    
    @IBAction func homeButtonTouched(_ sender: UIButton) {
        self.gameInfo.team = self.homeTeam
        self.viewModel.setModel(with: self.gameInfo)
        self.viewModel.postSelection(with: self.gameInfo)
        self.homeTeamButton.isEnabled = false
        
        self.delegate.didPressButton(with: self.gameInfo)
    }
    
}
