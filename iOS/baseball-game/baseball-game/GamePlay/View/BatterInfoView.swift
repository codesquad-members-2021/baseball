//
//  BatterInfoView.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import UIKit

class BatterInfoView: UIView {

    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var infoLabel: UILabel!
    
    func updateLabels(from playerInfo: Player) {
        nameLabel.text = playerInfo.name
        infoLabel.text = playerInfo.info
    }
    
    func highlight() {
        self.backgroundColor = .lightGray
    }
    
    func unhighlight() {
        self.backgroundColor = .white
    }

}
