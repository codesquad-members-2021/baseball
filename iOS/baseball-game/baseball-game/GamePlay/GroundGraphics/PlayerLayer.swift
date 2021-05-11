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

    override init(layer: Any) {
        super.init(layer: layer)
        configure()
    }
    
    init(origin: CGPoint, size: CGSize) {
        super.init()
        self.frame = CGRect(origin: origin, size: size)
        configure()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
    }
    
    private func configure() {
        addFace()
        addBody()
    }
    
    private func addBody() {
        
        let bodyHeight = height * 0.65
        let bodyWidth = bodyHeight * 0.7
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
        
        let faceHeight = height * 0.35
        let faceWidth = faceHeight
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
