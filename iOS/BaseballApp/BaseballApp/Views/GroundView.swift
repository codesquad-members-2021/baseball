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
    let firstBaseLayer = CAShapeLayer()
    let secondBaseLayer = CAShapeLayer()
    let thirdBaseLayer = CAShapeLayer()
    
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
        
        layer.addSublayer(firstBaseLayer)
        firstBaseLayer.strokeColor = UIColor.systemGray.cgColor
        firstBaseLayer.fillColor = UIColor.white.cgColor
        firstBaseLayer.lineWidth = 1.0
        
        layer.addSublayer(secondBaseLayer)
        secondBaseLayer.strokeColor = UIColor.systemGray.cgColor
        secondBaseLayer.fillColor = UIColor.white.cgColor
        secondBaseLayer.lineWidth = 1.0
        
        layer.addSublayer(thirdBaseLayer)
        thirdBaseLayer.strokeColor = UIColor.systemGray.cgColor
        thirdBaseLayer.fillColor = UIColor.white.cgColor
        thirdBaseLayer.lineWidth = 1.0
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        
        let squarePath = UIBezierPath()
        /// Home Plate
        squarePath.move(to: CGPoint(x: bounds.midX, y: bounds.maxY - 50.0))
        /// First Plate
        squarePath.addLine(to: CGPoint(x: bounds.maxX - 50.0, y: bounds.midY))
        /// Second Plate
        squarePath.addLine(to: CGPoint(x: bounds.midX, y: bounds.minY + 50.0))
        /// Third Plate
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
        
        let firstBasePath = UIBezierPath()
        firstBasePath.move(to: CGPoint(x: bounds.maxX - 65.0, y: bounds.midY))
        firstBasePath.addLine(to: CGPoint(x: bounds.maxX - 50.0, y: bounds.midY - 15.0))
        firstBasePath.addLine(to: CGPoint(x: bounds.maxX - 35.0, y: bounds.midY))
        firstBasePath.addLine(to: CGPoint(x: bounds.maxX - 50.0, y: bounds.midY + 15.0))
        firstBasePath.close()
        firstBaseLayer.path = firstBasePath.cgPath
        
        let secondBasePath = UIBezierPath()
        secondBasePath.move(to: CGPoint(x: bounds.midX - 15.0, y: bounds.minY + 50.0))
        secondBasePath.addLine(to: CGPoint(x: bounds.midX, y: bounds.minY + 35.0))
        secondBasePath.addLine(to: CGPoint(x: bounds.midX + 15.0, y: bounds.minY + 50.0))
        secondBasePath.addLine(to: CGPoint(x: bounds.midX, y: bounds.minY + 65.0))
        secondBasePath.close()
        secondBaseLayer.path = secondBasePath.cgPath
        
        let thirdBasePath = UIBezierPath()
        thirdBasePath.move(to: CGPoint(x: bounds.minX + 35.0, y: bounds.midY))
        thirdBasePath.addLine(to: CGPoint(x: bounds.minX + 50.0, y: bounds.midY - 15.0))
        thirdBasePath.addLine(to: CGPoint(x: bounds.minX + 65.0, y: bounds.midY))
        thirdBasePath.addLine(to: CGPoint(x: bounds.minX + 50.0, y: bounds.midY + 15.0))
        thirdBasePath.close()
        thirdBaseLayer.path = thirdBasePath.cgPath
    }
}
