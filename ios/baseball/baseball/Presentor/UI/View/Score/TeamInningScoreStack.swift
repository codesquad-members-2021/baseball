//
//  TeamInningScoreStack.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class TeamInningScoreStack: UIStackView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureUI()
    }

    required init(coder: NSCoder) {
        super.init(coder: coder)
        configureUI()
    }
    
    private func configureUI() {
        alignment = .center
    }
    
    func addInningViewLabels(inningsScore: [Int]) {
        inningsScore.forEach { score in
            let label = InningInfoLabel()
            label.text = "\(score)"
            addArrangedSubview(label)
        }
        
        emptyInningViewLables(emptyCount: 11-inningsScore.count)
    }
    
    private func emptyInningViewLables(emptyCount: Int) {
        for _ in 0..<emptyCount {
            let label = InningInfoLabel()
            addArrangedSubview(label)
        }
    }
}
