//
//  PitchButton.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class PitchButton: UIButton {
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configureUI()
    }
    
    private func configureUI() {
        layer.cornerRadius = 6
    }
}
