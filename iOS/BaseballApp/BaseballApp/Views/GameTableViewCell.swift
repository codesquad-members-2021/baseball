//
//  GameTableViewCell.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import UIKit

class GameTableViewCell: UITableViewCell {

    static let identifier = String(describing: GameTableViewCell.self)
    
    @IBOutlet weak var gameNumber: UILabel!
    @IBOutlet weak var awayTeamName: UILabel!
    @IBOutlet weak var homeTeamName: UILabel!

}
