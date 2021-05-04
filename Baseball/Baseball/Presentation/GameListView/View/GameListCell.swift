//
//  GameListCell.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/04.
//

import UIKit

class GameListCell: UICollectionViewCell {
    
    @IBOutlet weak var GameNumberLabel: UILabel!
    @IBOutlet weak var AwayTeamLabel: UILabel!
    @IBOutlet weak var HomeTeamLabel: UILabel!
    
    func configure() {
        self.contentView.layer.cornerRadius = 5
        self.backgroundColor = .systemGray3
    }
}
