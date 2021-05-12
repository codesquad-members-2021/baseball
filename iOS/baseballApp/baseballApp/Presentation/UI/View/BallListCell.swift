//
//  BallCountCell.swift
//  baseballApp
//
//  Created by 김지선 on 2021/05/12.
//

import UIKit

class ballListCell: UITableViewCell {
    @IBOutlet weak var ballIDLabel: UILabel!
    @IBOutlet weak var ballTypeLabel: UILabel!
    @IBOutlet weak var ballCountLabel: UILabel!
    @IBOutlet weak var strikeCountLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }


    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
//    func configureCell() {
//
//    }
    
    func configureUI() {
        ballIDLabel.layer.cornerRadius = ballIDLabel.bounds.width / 2
        
    }
}
