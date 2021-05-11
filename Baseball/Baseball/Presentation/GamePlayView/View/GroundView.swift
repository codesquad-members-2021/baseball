//
//  GroundView.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/04.
//

import UIKit

class GroundView: UIView {
    
    @IBOutlet weak var strikeHistoryView: PitchHistoryView!
    @IBOutlet weak var ballHistoryView: PitchHistoryView!
    @IBOutlet weak var outHistoryView: PitchHistoryView!

    private var centerPoint : CGPoint {
        return CGPoint(x: bounds.midX, y: bounds.midY)
    }
    private var configurationValue = ConfigurationValue()

    override func draw(_ rect: CGRect) {
        self.backgroundColor = .systemGray3
        UIColor.darkGray.set()
        groundPath()
        firstBase()
        secondBase()
        thirdBase()
        UIColor.white.set()
        homeBase()
        setSBO()
    }
    
    func setSBO() {
        strikeHistoryView.setKind(kind: SBO.Strike)
        ballHistoryView.setKind(kind: SBO.Ball)
        outHistoryView.setKind(kind: SBO.Out)
    }
    
    func groundPath() {
        let path = UIBezierPath()
        let centerPointX = centerPoint.x
        let centerPointY = centerPoint.y
        let halfDiagonal = configurationValue.groundHalfDiagonal
        path.move(to: CGPoint(x: centerPointX - halfDiagonal, y: centerPointY))
        path.addLine(to: CGPoint(x: centerPointX, y: centerPointY - halfDiagonal))
        path.addLine(to: CGPoint(x: centerPointX + halfDiagonal, y: centerPointY))
        path.addLine(to: CGPoint(x: centerPointX, y: centerPointY + halfDiagonal))
        path.addLine(to: CGPoint(x: centerPointX - halfDiagonal, y: centerPointY))
        path.close()
        path.lineWidth = 3.0
        path.stroke()
    }
    
    func base(movePoint: CGPoint, firstPoint: CGPoint, secondPoint: CGPoint, thirdPoint: CGPoint, forthPoint: CGPoint) {
        let path = UIBezierPath()
        path.move(to: movePoint)
        path.addLine(to: firstPoint)
        path.addLine(to: secondPoint)
        path.addLine(to: thirdPoint)
        path.addLine(to: forthPoint)
        path.close()
        path.lineWidth = 0.75
        UIColor.white.set()
        path.fill()
        UIColor.black.set()
        path.stroke()
    }
    
    func thirdBase() {
        let centerPointX = centerPoint.x
        let centerPointY = centerPoint.y
        let halfDiagonal = configurationValue.groundHalfDiagonal
        let baseHalfDiagonal = configurationValue.baseHalfDiagonal
        self.base(movePoint: CGPoint(x: centerPointX - halfDiagonal - baseHalfDiagonal, y: centerPointY),
                  firstPoint: CGPoint(x: centerPointX - halfDiagonal, y: centerPointY - baseHalfDiagonal),
                  secondPoint: CGPoint(x: centerPointX - halfDiagonal + baseHalfDiagonal, y: centerPointY),
                  thirdPoint: CGPoint(x: centerPointX - halfDiagonal, y: centerPointY + baseHalfDiagonal),
                  forthPoint: CGPoint(x: centerPointX - halfDiagonal - baseHalfDiagonal, y: centerPointY))
    }
    
    func secondBase() {
        let centerPointX = centerPoint.x
        let centerPointY = centerPoint.y
        let halfDiagonal = configurationValue.groundHalfDiagonal
        let baseHalfDiagonal = configurationValue.baseHalfDiagonal
        self.base(movePoint: CGPoint(x: centerPointX - baseHalfDiagonal, y: centerPointY - halfDiagonal),
                  firstPoint: CGPoint(x: centerPointX, y: centerPointY - halfDiagonal - baseHalfDiagonal),
                  secondPoint: CGPoint(x: centerPointX + baseHalfDiagonal, y: centerPointY - halfDiagonal),
                  thirdPoint: CGPoint(x: centerPointX, y: centerPointY - halfDiagonal + baseHalfDiagonal),
                  forthPoint: CGPoint(x: centerPointX - baseHalfDiagonal, y: centerPointY - halfDiagonal))
    }
    
    func firstBase() {
        let centerPointX = centerPoint.x
        let centerPointY = centerPoint.y
        let halfDiagonal = configurationValue.groundHalfDiagonal
        let baseHalfDiagonal = configurationValue.baseHalfDiagonal
        self.base(movePoint: CGPoint(x: centerPointX + halfDiagonal - baseHalfDiagonal, y: centerPointY),
                  firstPoint: CGPoint(x: centerPointX + halfDiagonal, y: centerPointY - baseHalfDiagonal),
                  secondPoint: CGPoint(x: centerPointX + halfDiagonal + baseHalfDiagonal, y: centerPointY),
                  thirdPoint: CGPoint(x: centerPointX + halfDiagonal, y: centerPointY + baseHalfDiagonal),
                  forthPoint: CGPoint(x: centerPointX + halfDiagonal - baseHalfDiagonal, y: centerPointY))
    }
    
    func homeBase() {
        let path = UIBezierPath()
        let centerPointX = centerPoint.x
        let centerPointY = centerPoint.y
        let halfDiagonal = configurationValue.groundHalfDiagonal
        let baseHalfDiagonal = configurationValue.baseHalfDiagonal
        let homeRectLength = configurationValue.homeRectLength
        path.move(to: CGPoint(x: centerPointX - baseHalfDiagonal, y: centerPointY + halfDiagonal))
        path.addLine(to: CGPoint(x: centerPointX, y: centerPointY + halfDiagonal - baseHalfDiagonal))
        path.addLine(to: CGPoint(x: centerPointX + baseHalfDiagonal, y: centerPointY + halfDiagonal))
        path.addLine(to: CGPoint(x: centerPointX + baseHalfDiagonal, y: centerPointY + halfDiagonal + homeRectLength))
        path.addLine(to: CGPoint(x: centerPointX - baseHalfDiagonal, y: centerPointY + halfDiagonal + homeRectLength))
        path.addLine(to: CGPoint(x: centerPointX - baseHalfDiagonal, y: centerPointY + halfDiagonal))
        path.close()
        path.lineWidth = 1.0
        path.stroke()
        path.fill()
    }
}

struct ConfigurationValue {
    let groundHalfDiagonal = CGFloat(120)
    let baseHalfDiagonal = CGFloat(12)
    let homeRectLength = CGFloat(12 * 2.squareRoot())
}
