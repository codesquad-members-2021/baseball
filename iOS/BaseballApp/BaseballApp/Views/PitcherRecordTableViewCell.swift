//
//  PitcherHistoryTableViewCell.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class PitcherRecordTableViewCell: UITableViewCell {
    @IBOutlet weak var numberLabel: UILabel!
    @IBOutlet weak var result: UILabel!
    @IBOutlet weak var count: UILabel!

    static func nib() -> UINib {
        return UINib(nibName: self.identifier, bundle: nil)
    }
    
    override func awakeFromNib() {
        numberLabel.layer.masksToBounds = true
        numberLabel.layer.cornerRadius = numberLabel.frame.width / 2
    }
    
    func configure(record: Record) {
        result.text = record.result
        let strike = record.strikeCount
        let ball = record.ballCount
        count.text = "\(strike)-\(ball)"
    }
}
