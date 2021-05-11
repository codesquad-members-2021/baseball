//
//  BallCountCell.swift
//  Baseball
//
//  Created by sonjuhyeong on 2021/05/07.
//

import UIKit

class BallCountCell: UITableViewCell {

    static let identifier = "BallCountCell"
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    static var nib: UINib {
        return UINib(nibName: identifier, bundle: nil)
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
}
