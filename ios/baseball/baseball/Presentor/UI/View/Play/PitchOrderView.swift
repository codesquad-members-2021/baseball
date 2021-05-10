//
//  PicthOrderView.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class PitchOrderView: UIView {
    let pitchOrderLabel = PitchOrderLabel()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configureUI()
    }
    
    private func configureUI() {
        backgroundColor = .black
        widthAnchor.constraint(equalTo: heightAnchor).isActive = true
        layer.cornerRadius = bounds.width / 2
        configureOrderLabel()
    }
    
    private func configureOrderLabel() {
        addSubview(pitchOrderLabel)
        pitchOrderLabel.frame = bounds
    }
}
