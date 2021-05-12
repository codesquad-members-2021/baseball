//
//  GameTableViewCell.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import UIKit

class RoomTableViewCell: UITableViewCell {
    
    @IBOutlet weak var roomNumber: UILabel!
    @IBOutlet weak var awayTeamName: UILabel!
    @IBOutlet weak var homeTeamName: UILabel!

    func fill(data: Room) {
        roomNumber.text = "\(data.id)"
        awayTeamName.text = data.awayTeam
        homeTeamName.text = data.homeTeam
    }
}
