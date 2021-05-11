//
//  PitchListTableViewCell.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import UIKit

class PitchListTableViewCell: UITableViewCell, IdentifierReusable {
    
    @IBOutlet weak var countLabel: UILabel!
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var logLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    func updateLabels(count: Int, result: String, log: String) {
        self.countLabel.text = "\(count)"
        self.resultLabel.text = result
        self.logLabel.text = log
    }

}
