//
//  PitchOrderLabel.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class PitchOrderLabel: UILabel {
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configureUI()
    }
    
    private func configureUI() {
        textColor = .white
        textAlignment = .center
    }
}
