//
//  PitchButton.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/06.
//

import UIKit

final class PitchButton: UIButton {
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupView()
    }
    
    private func setupView() {
        self.layer.cornerRadius = 4
        self.clipsToBounds = true
        self.backgroundColor = .black
        setTitle("PITCH", for: .normal)
        
        guard let text = self.titleLabel?.text else { return }
        let attributedString = NSMutableAttributedString(string: text)
        let stringLength = attributedString.length
        attributedString.addAttributes([.font: UIFont.boldSystemFont(ofSize: 18)], range: NSRange(location: 0, length: stringLength))
        titleLabel?.attributedText = attributedString
    }
    
}
