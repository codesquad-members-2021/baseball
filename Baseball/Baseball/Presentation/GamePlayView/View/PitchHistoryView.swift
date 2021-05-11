//
//  PitchHistoryView.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/06.
//

import UIKit

enum SBO {
    case Strike
    case Ball
    case Out
    
    func circleCount() -> Int {
        switch self {
        case .Strike, .Out:
            return 2
        case .Ball:
            return 3
        }
    }
    
    func color() -> UIColor {
        switch self {
        case .Strike:
            return UIColor.systemYellow
        case .Ball:
            return UIColor.systemGreen
        case .Out:
            return UIColor.systemRed
        }
    }
}

class PitchHistoryView: UIView {

    private var kind: SBO?
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.backgroundColor = UIColor.clear
    }
    
    private var centerPoint : CGPoint {
        return CGPoint(x: bounds.midX, y: bounds.midY)
    }
    
    override func draw(_ rect: CGRect) {
        for i in 0..<kind!.circleCount() {
            drawCircle(with: i)
        }
    }
        
    func setKind(kind: SBO){
        self.kind = kind
        setNeedsDisplay()
    }
    
    func drawCircle(with index: Int) {
        let circlePath = UIBezierPath(
            arcCenter: CGPoint(x: self.frame.width / 8 * CGFloat((3+(index*2))), y: centerPoint.y),
            radius: 8,
            startAngle: 0,
            endAngle: CGFloat(2*Double.pi),
            clockwise: true)
        circlePath.stroke()
    }
}
