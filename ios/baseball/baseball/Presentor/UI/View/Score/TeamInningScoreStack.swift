//
//  TeamInningScoreStack.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

@IBDesignable
final class TeamInningScoreStack: UIStackView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        addInningViewLabels()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        addInningViewLabels()
    }
    
    private func addInningViewLabels() {
        let max = 12
        for _ in 0..<max {
            let label = InningInfoLabel()
            addArrangedSubview(label)
        }
    }
}
