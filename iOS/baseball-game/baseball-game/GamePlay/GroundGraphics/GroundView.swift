//
//  GroundView.swift
//  baseball-game
//
//  Created by Song on 2021/05/10.
//

import UIKit

class GroundView: UIView {

    enum Color {
        static let groundGreen = (UIColor(named: "GroundGreen") ?? UIColor.green).cgColor
        static let groundBrown = (UIColor(named: "GroundBrown") ?? UIColor.brown ).cgColor
        static let base = (UIColor(named: "Base") ?? UIColor.white).cgColor
        static let baseSelected = (UIColor(named: "BaseSelected") ?? UIColor.blue).cgColor
        static let home = (UIColor(named: "Home") ?? UIColor.blue).cgColor
        static let border = UIColor.lightGray.cgColor
    }
    
    private var width: CGFloat {
        return self.frame.width
    }
    
    private var height: CGFloat {
        return self.frame.height
    }
    
    private let diamondAngle = CGFloat(45.0 * .pi / 180)
    
    //MARK: - Graphics with no animation
    override func draw(_ rect: CGRect) {
        super.draw(rect)
        
        guard let context = UIGraphicsGetCurrentContext() else { return }
        drawGround(with: context)
    }
    
    private func drawGround(with context: CGContext) {
        
        let centerX = width / 2
        let centerY = height / 2
        let groundWidth = width * 0.58
        let groundHeight = groundWidth
        
        let homeBasePoint = CGPoint(x: centerX, y: centerY + groundHeight / 2)
        let firstBasePoint = CGPoint(x: centerX + groundWidth / 2, y: centerY)
        let secondBasePoint = CGPoint(x: centerX, y: centerY - groundHeight / 2)
        let thirdBasePoint = CGPoint(x: centerX - groundWidth / 2, y: centerY)
        
        context.setLineWidth(groundWidth * 0.02)
        context.setStrokeColor(Color.border)
        context.addLines(between: [homeBasePoint, firstBasePoint, secondBasePoint, thirdBasePoint, homeBasePoint])
        context.strokePath()
        
        let groundCenter = CGPoint(x: centerX, y: centerY)
        drawGroundCircle(with: context, center: groundCenter)
        
        drawHomeBase(with: context, center: homeBasePoint)

    }
    
    private func drawGroundCircle(with context: CGContext, center: CGPoint) {
        
        let radius = width * 0.1
        context.setFillColor(Color.groundBrown)
        context.addArc(center: center, radius: radius, startAngle: 0, endAngle: diamondAngle * 8, clockwise: true)
        context.fillPath()
        
    }
    
    private func drawHomeBase(with context: CGContext, center: CGPoint) {
        
        let baseWidth = width * 0.1
        let baseHeight = baseWidth * 1.5
        let shortBaseHeight = baseHeight * 0.6
        
        let highCenterPoint = CGPoint(x: center.x, y: center.y - baseHeight / 2)
        let midRightPoint = CGPoint(x: center.x + baseWidth / 2, y: center.y + baseHeight / 2 - shortBaseHeight)
        let lowRightPoint = CGPoint(x: center.x + baseWidth / 2, y: center.y + baseHeight / 2)
        let lowLeftPoint = CGPoint(x: center.x - baseWidth / 2, y: center.y + baseHeight / 2)
        let midLeftPoint = CGPoint(x: center.x - baseWidth / 2, y: center.y + baseHeight / 2 - shortBaseHeight)
        
        context.setFillColor(Color.home)
        context.addLines(between: [highCenterPoint, midRightPoint, lowRightPoint, lowLeftPoint, midLeftPoint, highCenterPoint])
        context.fillPath()
        
    }
    
    //MARK: - Layers for animation
    struct BaseDrawingProperty {
        let id: Int
        let origin: CGPoint
        let size: CGSize
    }
    
    private var firstBaseProperty: BaseDrawingProperty?
    private var secondBaseProperty: BaseDrawingProperty?
    private var thirdBaseProperty: BaseDrawingProperty?
    
    private var baseLayers: [Int: CALayer] = [:]
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
    }
    
    private func configure() {
        self.backgroundColor = UIColor(cgColor: Color.groundGreen)
        configureBaseProperties()
        addBases()
    }

    private func configureBaseProperties() {
        
        let baseWidth = width * 0.09
        let baseHeight = baseWidth
        let baseXPosition = width / 2 - baseWidth / 2
        let baseYPosition = height / 2 - baseHeight / 2
        let distance = width / 4 + baseWidth / 2
        
        let baseSize = CGSize(width: baseWidth, height: baseHeight)
        let firstBaseOrigin = CGPoint(x: baseXPosition + distance, y: baseYPosition)
        let secondBaseOrigin = CGPoint(x: baseXPosition, y: baseYPosition - distance)
        let thirdBaseOrigin = CGPoint(x: baseXPosition - distance, y: baseYPosition)
        
        self.firstBaseProperty = BaseDrawingProperty(id: 1, origin: firstBaseOrigin, size: baseSize)
        self.secondBaseProperty = BaseDrawingProperty(id: 2, origin: secondBaseOrigin, size: baseSize)
        self.thirdBaseProperty = BaseDrawingProperty(id: 3, origin: thirdBaseOrigin, size: baseSize)
    }
    
    private func addBases() {
        
        guard let firstBaseProperty = self.firstBaseProperty, let secondBaseProperty = self.secondBaseProperty,
              let thirdBaseProperty = self.thirdBaseProperty else { return }
        
        let baseProperties = [firstBaseProperty, secondBaseProperty, thirdBaseProperty]
        
        baseProperties.forEach { baseProperty in
            self.addBase(id: baseProperty.id, origin: baseProperty.origin, size: baseProperty.size)
        }

    }
    
    private func addBase(id: Int, origin: CGPoint, size: CGSize) {
        
        let base = CALayer()
        base.frame = CGRect(origin: origin, size: size)
        base.backgroundColor = Color.base
        base.borderColor = Color.border
        base.borderWidth = base.frame.width * 0.02
        base.transform = CATransform3DMakeRotation(diamondAngle, 0.0, 0.0, 1.0)
        
        layer.addSublayer(base)
        self.baseLayers[id] = base
        
    }

}
