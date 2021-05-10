//
//  GameStoryTableViewCell.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/05.
//

import UIKit

final class GameStoryTableViewCell: UITableViewCell {
    @IBOutlet weak var countImage: UIImageView!
    @IBOutlet weak var countLabel: UILabel!
    @IBOutlet weak var countNumberLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()

    }


    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

    }
    
}
