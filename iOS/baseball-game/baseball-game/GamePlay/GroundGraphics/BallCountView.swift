//
//  BallCountView.swift
//  baseball-game
//
//  Created by Song on 2021/05/10.
//

import UIKit

class BallCountView: UIView {
    
    enum Color {
        static let strike = (UIColor(named: "Strike") ?? UIColor.green).cgColor
        static let ball = (UIColor(named: "Ball") ?? UIColor.yellow).cgColor
        static let out = (UIColor(named: "Out") ?? UIColor.red).cgColor
        static let clear = UIColor.clear.cgColor
        static let border = UIColor.lightGray.cgColor
        static let text = UIColor.white.cgColor
        static let back = UIColor.black.cgColor
    }
    
    private var width: CGFloat {
        return self.frame.width
    }
    
    private var height: CGFloat {
        return self.frame.height
    }
    
    struct DrawingProperty {
        let color: CGColor
        let row: Int
        let maxColumn: Int
        
        init(_ color: CGColor, row: Int, maxColumn: Int) {
            self.color = color
            self.row = row - 1
            self.maxColumn = maxColumn
        }
    }
    
    private let strikeProperty = DrawingProperty(Color.strike, row: 1, maxColumn: 2)
    private let ballProperty = DrawingProperty(Color.ball, row: 2, maxColumn: 3)
    private let outProperty = DrawingProperty(Color.out, row: 3, maxColumn: 2)
    
    private var countCircleLayers: [Int: [CALayer]] = [:]

    func configure() {
        let drawingProperties = [strikeProperty, ballProperty, outProperty]

        for property in drawingProperties {
            let row = property.row
            let maxColumn = property.maxColumn
            for column in 0..<maxColumn {
                addCircle(to: row, column, color: property.color)
            }
        }
    }
    
    private func addCircle(to row: Int, _ column: Int, color: CGColor) {
        let rowInCGFloat = CGFloat(row), columnInCGFloat = CGFloat(column)
        let circle = CALayer()
        let circleWidth = width * 0.18
        
        circle.frame = CGRect(x: width * 0.3 + columnInCGFloat * width * 0.2,
                              y: width * 0.1 + rowInCGFloat * width * 0.3,
                              width: circleWidth, height: circleWidth)
        circle.backgroundColor = color
        circle.borderWidth = width * 0.02
        circle.borderColor = Color.border
        circle.cornerRadius = circle.frame.width * 0.5
        
        layer.addSublayer(circle)
        append(layer: circle, to: row)
    }
    
    private func append(layer: CALayer, to row: Int) {
        if countCircleLayers[row] != nil {
            countCircleLayers[row]!.append(layer)
        } else {
            countCircleLayers[row] = [layer]
        }
    }
    
    func reset() {
        layer.sublayers?.forEach({ layer in
            layer.backgroundColor = Color.clear
        })
    }
    
    func fillStrike(upto count: Int) {
        fill(with: strikeProperty, upto: count)
    }
    
    func fillBall(upto count: Int) {
        fill(with: ballProperty, upto: count)
    }
    
    func fillOut(upto count: Int) {
        fill(with: outProperty, upto: count)
    }
    
    private func fill(with property: DrawingProperty, upto count: Int) {
        guard let targetLayers = countCircleLayers[property.row] else { return }

        if count > property.maxColumn {
            targetLayers.forEach { layer in
                layer.backgroundColor = Color.clear
            }
        } else {
            targetLayers[0..<count].forEach { layer in
                layer.backgroundColor = property.color
            }
        }
    }

}
