//
//  StadiumView.swift
//  baseballApp
//
//  Created by 김지선 on 2021/05/07.
//

import UIKit

class StadiumView: UIView {
    private lazy var height = self.bounds.height
    private lazy var width = self.bounds.width
    private lazy var baseInterval = Float(width)/3.3
    private lazy var basePoints = [CGPoint]()
    private lazy var fieldCenter = CGPoint(x: bounds.midX, y: bounds.midY)
    
    
    override func draw(_ rect: CGRect) {
        drawField(UIGraphicsGetCurrentContext()!)
    }
       
    func drawField(_ context: CGContext) {
        context.setStrokeColor(UIColor.gray.cgColor)
        context.setLineWidth(4.0)
        drawRotatedRect(context, center: fieldCenter, length: baseInterval, mode: .stroke)
        context.setFillColor(UIColor.white.cgColor)
        context.setLineWidth(1.0)
        drawBase(context)
    }
    
    func drawBase(_ context: CGContext) {
        let baseSize: Float = 15.0
        let homeBase = CGPoint(x: fieldCenter.x, y: fieldCenter.y + CGFloat(baseInterval))
        let firstBase = CGPoint(x: fieldCenter.x + CGFloat(baseInterval), y: fieldCenter.y)
        let secondBase =  CGPoint(x: fieldCenter.x, y: fieldCenter.y - CGFloat(baseInterval))
        let thirdBase = CGPoint(x: fieldCenter.x - CGFloat(baseInterval), y: fieldCenter.y)
        drawRotatedRect(context, center: homeBase, length: baseSize, mode: .fillStroke)
        drawRotatedRect(context, center: firstBase, length: baseSize, mode: .fillStroke)
        drawRotatedRect(context, center: secondBase, length: baseSize, mode: .fillStroke)
        drawRotatedRect(context, center: thirdBase, length: baseSize, mode: .fillStroke)
    }
    
    func drawRotatedRect(_ context: CGContext, center: CGPoint, length: Float, mode: CGPathDrawingMode) {
        context.move(to: CGPoint(x: center.x, y: center.y + CGFloat(length)))
        let points = [
            CGPoint(x: center.x, y: center.y + CGFloat(length)),
            CGPoint(x: center.x + CGFloat(length), y: center.y),
            CGPoint(x: center.x, y: center.y - CGFloat(length)),
            CGPoint(x: center.x - CGFloat(length), y: center.y)
        ]
        context.addLines(between: points)
        context.closePath()
        context.drawPath(using: mode)
    }
    
    func drawPlayer() {
        let layer = CALayer()
    }
}

