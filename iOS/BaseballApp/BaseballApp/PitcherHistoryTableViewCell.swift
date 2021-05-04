//
//  PitcherHistoryTableViewCell.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class PitcherHistoryTableViewCell: UITableViewCell {
    
    static let identifier = String(describing: PitcherHistoryTableViewCell.self)

    static func nib() -> UINib {
        return UINib(nibName: identifier, bundle: nil)
    }
}
