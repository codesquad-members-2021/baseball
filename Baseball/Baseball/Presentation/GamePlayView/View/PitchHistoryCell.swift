//
//  PitchHistoryCell.swift
//  Baseball
//
//  Created by 지북 on 2021/05/06.
//

import UIKit

class PitchHistoryCell: UITableViewCell {
    @IBOutlet weak var numberLabel: UILabel!
    @IBOutlet weak var pitchResultLabel: UILabel!
    @IBOutlet weak var pitchResultTotalLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
