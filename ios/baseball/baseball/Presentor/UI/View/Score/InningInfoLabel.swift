//
//  InningInfoLabel.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class InningInfoLabel: UILabel {
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configureUI()
    }
    
    private func configureUI() {
        font = UIFont.systemFont(ofSize: 13, weight: .semibold)
    }
}
