//
//  MatchView.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class GroundView: UIView {
    
    static let identifier = String(describing: GroundView.self)
    
    override func awakeFromNib() {
        self.backgroundColor = .gray
    }
}
