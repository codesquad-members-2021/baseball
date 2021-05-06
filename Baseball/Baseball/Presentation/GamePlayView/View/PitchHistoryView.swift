//
//  PitchHistoryView.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/06.
//

import UIKit

class PitchHistoryView: UIView {

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.backgroundColor = UIColor.clear
    }
    
    private var centerPoint : CGPoint {
        return CGPoint(x: bounds.midX, y: bounds.midY)
    }
    
    override func draw(_ rect: CGRect) {
        drawFirstCircle()
        drawSecondCircle()
        drawThirdCircle()
    }
        
    func drawFirstCircle() {
        let circlePath = UIBezierPath(
            arcCenter: CGPoint(x: self.frame.width / 8 * 3, y: centerPoint.y),
            radius: 8,
            startAngle: 0,
            endAngle: CGFloat(2*Double.pi),
            clockwise: true)
        circlePath.stroke()
    }
    
    func drawSecondCircle() {
        let circlePath = UIBezierPath(
            arcCenter: CGPoint(x: self.frame.width / 8 * 5, y: centerPoint.y),
            radius: 8,
            startAngle: 0,
            endAngle: CGFloat(2*Double.pi),
            clockwise: true)
        circlePath.stroke()
    }
    
    func drawThirdCircle() {
        let circlePath = UIBezierPath(
            arcCenter: CGPoint(x: self.frame.width / 8 * 7, y: centerPoint.y),
            radius: 8,
            startAngle: 0,
            endAngle: CGFloat(2*Double.pi),
            clockwise: true)
        circlePath.stroke()
    }
    
}
