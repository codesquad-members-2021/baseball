//
//  PlayerLayer.swift
//  baseball-game
//
//  Created by Song on 2021/05/11.
//

import UIKit

class PlayerLayer: CALayer {
    
    enum Color {
        static let face = UIColor.purple.cgColor
        static let eye = UIColor.black.cgColor
        static let body = UIColor.purple.cgColor
        static let border = UIColor.black.cgColor
    }
    
    private var width: CGFloat {
        return self.frame.width
    }
    
    private var height: CGFloat {
        return self.frame.height
    }
    
    func configure() {
        addBody()
        addFace()
    }
    
    private func addBody() {
        
        let bodyWidth = width
        let bodyHeight = width * 1.2
        let bodySize = CGSize(width: bodyWidth, height: bodyHeight)
        
        let bodyXPosition = width / 2 - bodyWidth / 2
        let bodyYPosition = height * 0.35
        let bodyOrigin = CGPoint(x: bodyXPosition, y: bodyYPosition)
        
        let body = CALayer()
        body.frame = CGRect(origin: bodyOrigin, size: bodySize)
        body.borderWidth = height * 0.02
        body.borderColor = Color.border
        body.backgroundColor = Color.body
        body.cornerRadius = bodyWidth * 0.2
        
        addSublayer(body)
        
    }
    
    private func addFace() {
        
        let faceWidth = width * 0.7
        let faceHeight = faceWidth
        let faceSize = CGSize(width: faceWidth, height: faceHeight)
        
        let faceXPosition = width / 2 - faceWidth / 2
        let faceOrigin = CGPoint(x: faceXPosition, y: 0)
        
        let face = CALayer()
        face.frame = CGRect(origin: faceOrigin, size: faceSize)
        face.borderWidth = height * 0.02
        face.borderColor = Color.border
        face.backgroundColor = Color.face
        face.cornerRadius = faceWidth * 0.5
        
        addSublayer(face)
        
    }
    
}
