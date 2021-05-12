//
//  CountView.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class CountView: UIView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
        translatesAutoresizingMaskIntoConstraints = false
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
    }
    
    private func configure() {
        widthAnchor.constraint(equalTo: heightAnchor).isActive = true
        hide()
    }
    
    func hide() {
        backgroundColor = .none
        layer.borderWidth = 0
    }
    
    func show(color: UIColor) {
        backgroundColor = color
        layer.borderWidth = 0.5
    }
}
