//
//  PlayerListCollectionViewCell.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/10.
//

import UIKit

class PlayerListCollectionViewCell: UICollectionViewCell {
    @IBOutlet weak var playerNameLabel: UILabel!
    @IBOutlet weak var plateAppearanceLabel: UILabel!
    @IBOutlet weak var hitsNumbersLabel: UILabel!
    @IBOutlet weak var accumulatedOutCountLabel: UILabel!
    @IBOutlet weak var averageLabel: UILabel!
    
    let underline: CALayer = {
       let layer = CALayer()
        layer.backgroundColor = UIColor.lightGray.cgColor
       return layer
    }()
    
    override func awakeFromNib() {
        super.awakeFromNib()
        self.layer.addSublayer(underline)
        
        self.underline.frame = CGRect(x: self.frame.width * 0.1 / 2, y: self.frame.maxY / 1.9, width: self.frame.width * 0.9, height: 1)
    }
    
    func configureCell(with player: Player) {
        self.playerNameLabel.text = player.name
        self.plateAppearanceLabel.text = "\(player.plateAppearance)"
        self.hitsNumbersLabel.text = "\(player.hitsNumbers)"
        self.accumulatedOutCountLabel.text = "\(player.accumulatedOutCount)"
        self.averageLabel.text = "1.000"
    }
}
