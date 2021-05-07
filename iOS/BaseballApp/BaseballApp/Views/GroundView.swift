//
//  MatchView.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class GroundView: UIView {
    
    static let identifier = String(describing: GroundView.self)
    let infieldSquareLayer = CAShapeLayer()
    let homePlateLayer = CAShapeLayer()
    
    override func awakeFromNib() {
        self.backgroundColor = .systemGray3
        addLine()
    }
    
    func addLine() {
        layer.addSublayer(infieldSquareLayer)
        infieldSquareLayer.strokeColor = UIColor.systemGray.cgColor
        infieldSquareLayer.fillColor = UIColor.clear.cgColor
        infieldSquareLayer.lineWidth = 5.0
        //shapeLayer.strokeEnd = 1
        
        layer.addSublayer(homePlateLayer)
        homePlateLayer.fillColor = UIColor.white.cgColor
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        
        let squarePath = UIBezierPath()
        squarePath.move(to: CGPoint(x: bounds.midX, y: bounds.maxY - 50.0))
        squarePath.addLine(to: CGPoint(x: bounds.maxX - 50.0, y: bounds.midY))
        squarePath.addLine(to: CGPoint(x: bounds.midX, y: bounds.minY + 50.0))
        squarePath.addLine(to: CGPoint(x: bounds.minX + 50.0, y: bounds.midY))
        squarePath.close()
        infieldSquareLayer.path = squarePath.cgPath
        
        let platePath = UIBezierPath()
        platePath.move(to: CGPoint(x: bounds.midX, y: bounds.maxY - 70.0))
        platePath.addLine(to: CGPoint(x: bounds.midX - 15.0, y: bounds.maxY - 55.0))
        platePath.addLine(to: CGPoint(x: bounds.midX - 15.0, y: bounds.maxY - 25.0))
        platePath.addLine(to: CGPoint(x: bounds.midX + 15.0, y: bounds.maxY - 25.0))
        platePath.addLine(to: CGPoint(x: bounds.midX + 15.0, y: bounds.maxY - 55.0))
        platePath.close()
        homePlateLayer.path = platePath.cgPath
    }
}
