//
//  InningNumberStack.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

@IBDesignable
final class InningNumberStack: UIStackView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureUI()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        configureUI()
    }
    
    private func configureUI() {
        addInningNumberLabels()
        addTotalLabel()
    }
    
    private func addInningNumberLabels() {
        let inningNumberRange = 1...11
        inningNumberRange.forEach { inningNumber in
            let label = InningInfoLabel()
            label.text = String(inningNumber)
            addArrangedSubview(label)
        }
    }
    
    private func addTotalLabel() {
        let label = InningInfoLabel()
        label.text = "R"
        addArrangedSubview(label)
    }
}
