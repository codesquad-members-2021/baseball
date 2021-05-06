//
//  PlayView.swift
//  ProBaseball
//
//  Created by 오킹 on 2021/05/06.
//

import UIKit

class PlayView: UIView {

    var path: UIBezierPath!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    override func draw(_ rect: CGRect) {
        self.createRectangle()
        UIColor.darkGray.setStroke()
        path.lineWidth = 5
        path.stroke()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    func createRectangle() {
        
        let centerX = self.frame.width/2
        let leftPoint = self.frame.width / 4.5
        let rightPoint = self.frame.width / 1.3
        let topPoint = self.frame.height/8
        let bottomPoint = self.frame.height/1.15
        let centerY = self.frame.height/2

        path = UIBezierPath()
        path.move(to: CGPoint(x: centerX, y: topPoint))
        path.addLine(to: CGPoint(x: leftPoint, y: centerY))
        path.addLine(to: CGPoint(x: centerX, y: bottomPoint))
        path.addLine(to: CGPoint(x: rightPoint, y: centerY))
        path.close()
    }
    
}
