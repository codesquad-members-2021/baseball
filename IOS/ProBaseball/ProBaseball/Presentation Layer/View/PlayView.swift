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
    lazy var centerX = self.frame.width/2
    lazy var leftPoint = self.frame.width / 4.5
    lazy var rightPoint = self.frame.width / 1.3
    lazy var topPoint = self.frame.height/8
    lazy var bottomPoint = self.frame.height/1.15
    lazy var centerY = self.frame.height/2
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
        self.firstBase = DiamondView(frame: CGRect(x: rightPoint-(baseSize/2), y: centerY-(baseSize/2), width: baseSize, height: baseSize))
        self.secondBase = DiamondView(frame: CGRect(x: centerX-(baseSize/2), y: topPoint-(baseSize/2), width: baseSize, height: baseSize))
        self.thirdBase = DiamondView(frame: CGRect(x: leftPoint-(baseSize/2), y: centerY-(baseSize/2), width: baseSize, height: baseSize))
        self.homeBase = HomeView(frame: CGRect(x: centerX-(baseSize/2), y: bottomPoint-(baseSize/2), width: baseSize, height: baseSize*1.2))
        self.addSubview(firstBase)
        self.addSubview(secondBase)
        self.addSubview(thirdBase)
        self.addSubview(homeBase)
    }
    
    func createRectangle() {
        path = UIBezierPath()
        path.move(to: CGPoint(x: centerX, y: topPoint))
        path.addLine(to: CGPoint(x: leftPoint, y: centerY))
        path.addLine(to: CGPoint(x: centerX, y: bottomPoint))
        path.addLine(to: CGPoint(x: rightPoint, y: centerY))
        path.close()
    }
    
}
