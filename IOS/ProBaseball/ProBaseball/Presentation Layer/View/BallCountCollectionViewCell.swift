//
//  BallCountCollectionViewCell.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/06.
//

import UIKit

class BallCountCollectionViewCell: UICollectionViewCell {

    @IBOutlet weak var cellCount: UIButton!
    @IBOutlet weak var ballState: UILabel!
    @IBOutlet weak var ballStateHistoryNum: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
}
