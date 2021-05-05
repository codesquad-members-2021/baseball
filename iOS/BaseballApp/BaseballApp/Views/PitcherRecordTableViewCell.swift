//
//  PitcherHistoryTableViewCell.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class PitcherRecordTableViewCell: UITableViewCell {
    
    static let identifier = String(describing: PitcherRecordTableViewCell.self)

    static func nib() -> UINib {
        return UINib(nibName: identifier, bundle: nil)
    }
}
