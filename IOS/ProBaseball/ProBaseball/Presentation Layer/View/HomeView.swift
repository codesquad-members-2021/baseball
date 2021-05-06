//
//  HomeView.swift
//  ProBaseball
//
//  Created by 오킹 on 2021/05/06.
//

import UIKit

class HomeView: UIView {

    var path: UIBezierPath!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.backgroundColor = .clear
    }
    
    override func draw(_ rect: CGRect) {
        self.createRectangle()
        UIColor.white.setFill()
        path.fill()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    func createRectangle() {
        let centerX = self.frame.width/2
        let centerY = self.frame.height/2

        path = UIBezierPath()
        path.move(to: CGPoint(x: centerX, y: 0))
        path.addLine(to: CGPoint(x: 0, y: centerY/2))
        path.addLine(to: CGPoint(x: 0, y: self.frame.height))
        path.addLine(to: CGPoint(x: self.frame.width, y: self.frame.height))
        path.addLine(to: CGPoint(x: self.frame.width, y: centerY/2))
        path.close()
    }
}
