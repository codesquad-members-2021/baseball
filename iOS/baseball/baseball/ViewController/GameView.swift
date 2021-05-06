//
//  GameView.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/04.
//

import UIKit
import SnapKit

class GameView: UIView {
    
    override func draw(_ rect: CGRect) {
        let path = UIBezierPath()
        let path2 = UIBezierPath()
        path.lineWidth = 2
        
        // 이동경로 그리기
        path.move(to: CGPoint(x: self.frame.width / 2, y: self.frame.height - 50))
        path.addLine(to: CGPoint(x: self.frame.width/2 + 115, y: self.frame.height/2 ))
        path.addLine(to: CGPoint(x: self.frame.width/2, y: 50))
        path.addLine(to: CGPoint(x: self.frame.width/2 - 115, y: self.frame.height/2))
        path.close()
        UIColor.systemGray.set()
        path.stroke()
        
        // 홈베이스 그리기
        path2.move(to: CGPoint(x: 207, y: 248))
        path2.addLine(to: CGPoint(x: 196, y: 268))
        path2.addLine(to: CGPoint(x: 196, y: 286))
        path2.addLine(to: CGPoint(x: 218, y: 286))
        path2.addLine(to: CGPoint(x: 218, y: 268))
        path2.close()
        
        UIColor.systemBackground.set()
        path2.fill()
        
    }
}
