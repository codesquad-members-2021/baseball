//
//  PlayView.swift
//  ProBaseball
//
//  Created by 오킹 on 2021/05/06.
//

import UIKit

class PlayView: UIView {

    var path: UIBezierPath!
    var firstBase: DiamondView!
    var secondBase: DiamondView!
    var thirdBase: DiamondView!
    var homeBase: HomeView!
    
    lazy var centerX = self.bounds.midX
    lazy var centerY = self.bounds.midY
    lazy var baseSize: CGFloat = 40
    
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
        drawBase()
    }
    
    func drawBase() {
        let halfBaseSize = baseSize/2
        let maxX = self.bounds.maxX - halfBaseSize
        let minX = self.bounds.minX - halfBaseSize
        let minY = self.bounds.minY - halfBaseSize
        let baseCenterX = centerX - halfBaseSize
        let baseCenterY = centerY - halfBaseSize
  
        self.firstBase = DiamondView(frame: CGRect(x: maxX, y: baseCenterY, width: baseSize, height: baseSize))
        self.secondBase = DiamondView(frame: CGRect(x: baseCenterX, y: minY, width: baseSize, height: baseSize))
        self.thirdBase = DiamondView(frame: CGRect(x: minX, y: baseCenterY, width: baseSize, height: baseSize))
        self.homeBase = HomeView(frame: CGRect(x: baseCenterX, y: self.bounds.maxY-(baseSize/1.2), width: baseSize, height: baseSize*1.2))
        self.addSubview(firstBase)
        self.addSubview(secondBase)
        self.addSubview(thirdBase)
        self.addSubview(homeBase)
    }
    
    func createRectangle() {
        path = UIBezierPath()
        path.move(to: CGPoint(x: centerX, y: 0))
        path.addLine(to: CGPoint(x: 0, y: centerY))
        path.addLine(to: CGPoint(x: centerX, y: self.frame.height))
        path.addLine(to: CGPoint(x: self.frame.width, y: centerY))
        path.close()
    }
    
}
