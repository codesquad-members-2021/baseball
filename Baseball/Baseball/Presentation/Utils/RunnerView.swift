//
//  RunnerView.swift
//  Baseball
//
//  Created by 지북 on 2021/05/12.
//

import UIKit

class RunnerView: UIView {

    private var centerPoint : CGPoint {
        return CGPoint(x: bounds.midX, y: bounds.midY)
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.backgroundColor = .clear
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.backgroundColor = .clear
        self.isHidden = true
    }
    
    override func draw(_ rect: CGRect) {
        firstBase()
    }
    
    private func base(movePoint: CGPoint, firstPoint: CGPoint, secondPoint: CGPoint, thirdPoint: CGPoint, forthPoint: CGPoint) {
        let path = UIBezierPath()
        path.move(to: movePoint)
        path.addLine(to: firstPoint)
        path.addLine(to: secondPoint)
        path.addLine(to: thirdPoint)
        path.addLine(to: forthPoint)
        path.close()
        path.lineWidth = 0.75
        UIColor.yellow.set()
        path.fill()
        UIColor.black.set()
        path.stroke()
    }

    private func firstBase() {
        let centerPointX = centerPoint.x
        let centerPointY = centerPoint.y
        self.base(movePoint: CGPoint(x: centerPointX - 12, y: centerPointY),
                  firstPoint: CGPoint(x: centerPointX , y: centerPointY - 12),
                  secondPoint: CGPoint(x: centerPointX + 12, y: centerPointY),
                  thirdPoint: CGPoint(x: centerPointX, y: centerPointY + 12),
                  forthPoint: CGPoint(x: centerPointX - 12, y: centerPointY))
    }
    
}

