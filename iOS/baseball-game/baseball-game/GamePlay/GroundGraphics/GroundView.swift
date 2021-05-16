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
        static let groundBrown = (UIColor(named: "GroundBrown") ?? UIColor.brown).cgColor
        static let base = (UIColor(named: "Base") ?? UIColor.white).cgColor
        static let baseSelected = (UIColor(named: "BaseSelected") ?? UIColor.blue).cgColor
        static let home = (UIColor(named: "Home") ?? UIColor.blue).cgColor
        static let border = (UIColor(named: "GroundBorder") ?? UIColor.black).cgColor
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
        
        func centerMovedBy(x: CGFloat, y: CGFloat) -> CGPoint {
            let newX = origin.x + x + size.width / 2
            let newY = origin.y + y - size.height / 2
            return CGPoint(x: newX, y: newY)
        }
    }
    
    private var firstBaseProperty: BaseDrawingProperty?
    private var secondBaseProperty: BaseDrawingProperty?
    private var thirdBaseProperty: BaseDrawingProperty?
    private var homeBaseProperty: BaseDrawingProperty?
    
    private var baseLayers: [Int: CALayer] = [:]
    private var playerLayer: [PlayerLayer] = []
    
    enum Duration {
        static let total = 1.0
        static let player = 1.0
        static let base = 0.3
    }
    
    enum Delay {
        static let fast = 0.0
        static let late = 0.7
    }

    func configure() {
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
        let homeBaseOrigin = CGPoint(x: baseXPosition, y: baseYPosition + distance)
        
        self.firstBaseProperty = BaseDrawingProperty(id: 1, origin: firstBaseOrigin, size: baseSize)
        self.secondBaseProperty = BaseDrawingProperty(id: 2, origin: secondBaseOrigin, size: baseSize)
        self.thirdBaseProperty = BaseDrawingProperty(id: 3, origin: thirdBaseOrigin, size: baseSize)
        self.homeBaseProperty = BaseDrawingProperty(id: 4, origin: homeBaseOrigin, size: baseSize)
        
    }
    
    private func addBases() {
        
        guard let firstBaseProperty = self.firstBaseProperty, let secondBaseProperty = self.secondBaseProperty,
              let thirdBaseProperty = self.thirdBaseProperty, let homeBaseProperty = self.homeBaseProperty else { return }
        
        var baseProperties = [firstBaseProperty, secondBaseProperty, thirdBaseProperty]
        
        baseProperties.forEach { baseProperty in
            self.addBase(id: baseProperty.id, origin: baseProperty.origin, size: baseProperty.size)
        }
        
        baseProperties.append(homeBaseProperty)
        
        baseProperties.forEach { baseProperty in
            addPlayer(to: baseProperty)
        }

    }
    
    private func addBase(id: Int, origin: CGPoint, size: CGSize) {
        
        let base = CALayer()
        base.frame = CGRect(origin: origin, size: size)
        base.backgroundColor = Color.base
        base.transform = CATransform3DMakeRotation(diamondAngle, 0.0, 0.0, 1.0)
        
        layer.addSublayer(base)
        self.baseLayers[id] = base
        
    }
    
    private func addPlayer(to baseInfo: BaseDrawingProperty) {
        
        let playerWidth = width * 0.06
        let playerHeight = playerWidth * 1.5
        let playerSize = CGSize(width: playerWidth, height: playerHeight)
        
        let offsetX = playerWidth / 2
        let playerOrigin = baseInfo.centerMovedBy(x: -offsetX, y: 0)
        
        let player = PlayerLayer()
        player.frame = CGRect(origin: playerOrigin, size: playerSize)
        player.configure()
        
        layer.addSublayer(player)
    
        self.playerLayer.append(player)
        
    }
    
}

//MARK: - Animation Methods
extension GroundView {
    
    func reset() {
        playerLayer.forEach { playerLayer in
            playerLayer.opacity = 0
        }
        baseLayers.forEach { (_, baseLayer) in
            baseLayer.backgroundColor = Color.base
        }
    }
    
    func homeTofirstBase() {
        guard let homeBaseProperty = homeBaseProperty, let firstBaseProperty = firstBaseProperty else { return }
        
        playerLayer[0].opacity = 0
        
        CATransaction.begin()
        CATransaction.setAnimationDuration(Duration.total)
        
        animatePlayer(with: homeBaseProperty, firstBaseProperty, duration: Duration.player, delay: Delay.fast)
        animateBase(id: 1, toSelected: true, duration: Duration.base, delay: Delay.late)
        
        CATransaction.commit()
        
    }

    func firstBaseToSecondBase() {
        guard let firstBaseProperty = firstBaseProperty, let secondBaseProperty = secondBaseProperty else { return }
        
        playerLayer[1].opacity = 0
        
        CATransaction.begin()
        CATransaction.setAnimationDuration(Duration.total)
        
        animatePlayer(with: firstBaseProperty, secondBaseProperty, duration: Duration.player, delay: Delay.fast)
        animateBase(id: 1, toSelected: false, duration: Duration.base, delay: Delay.late)
        animateBase(id: 2, toSelected: true, duration: Duration.base, delay: Delay.late)
        
        CATransaction.commit()
        
    }

    func secondBaseToThirdBase() {
        guard let secondBaseProperty = secondBaseProperty, let thirdBaseProperty = thirdBaseProperty else { return }
        
        playerLayer[2].opacity = 0
        
        CATransaction.begin()
        CATransaction.setAnimationDuration(Duration.total)
        
        animatePlayer(with: secondBaseProperty, thirdBaseProperty, duration: Duration.player, delay: Delay.fast)
        animateBase(id: 2, toSelected: false, duration: Duration.base, delay: Delay.late)
        animateBase(id: 3, toSelected: true, duration: Duration.base, delay: Delay.late)
        
        CATransaction.commit()
    }

    func thirdBaseToHome() {
        guard let thirdBaseProperty = thirdBaseProperty, let homeBaseProperty = homeBaseProperty else { return }
        
        playerLayer[3].opacity = 0
        
        CATransaction.begin()
        CATransaction.setAnimationDuration(Duration.total)
        
        animatePlayer(with: thirdBaseProperty, homeBaseProperty, duration: Duration.player, delay: Delay.fast)
        animateBase(id: 3, toSelected: false, duration: Duration.base, delay: Delay.late)
        
        CATransaction.commit()
    }
    
    private func animatePlayer(with fromBaseInfo: BaseDrawingProperty,_ toBaseInfo: BaseDrawingProperty, duration: Double, delay: Double) {
        
        let targetIndex = toBaseInfo.id - 1
        
        guard playerLayer.count >= targetIndex else { return }
        
        let player = playerLayer[targetIndex]
        player.opacity = 100
        
        let offsetY = player.frame.height / 2
        let fromPosition = fromBaseInfo.centerMovedBy(x: 0, y: offsetY)
        let toPosition = toBaseInfo.centerMovedBy(x: 0, y: offsetY)

        CATransaction.setCompletionBlock {
            player.position = toPosition
            if targetIndex == 3 { player.opacity = 0 }
        }
        
        let positionAnimation = CASpringAnimation(keyPath: #keyPath(PlayerLayer.position))
        positionAnimation.damping = 10
        positionAnimation.mass = 0.7
        positionAnimation.fromValue = fromPosition
        positionAnimation.toValue = toPosition
        positionAnimation.timeOffset = delay
        positionAnimation.duration = duration
        player.add(positionAnimation, forKey: #keyPath(PlayerLayer.position))
        
        let opacityAnimation = CABasicAnimation(keyPath: #keyPath(PlayerLayer.opacity))
        opacityAnimation.fromValue = 0
        opacityAnimation.byValue = 100
        opacityAnimation.timeOffset = delay
        opacityAnimation.duration = duration * 0.1
        player.add(opacityAnimation, forKey: #keyPath(PlayerLayer.opacity))

        let opacityAnimation2 = CABasicAnimation(keyPath: #keyPath(PlayerLayer.opacity))
        opacityAnimation2.fromValue = 100
        opacityAnimation2.byValue = 0
        opacityAnimation2.timeOffset = delay + (duration * 0.8)
        opacityAnimation2.duration = duration * 0.1
        player.add(opacityAnimation2, forKey: #keyPath(PlayerLayer.opacity))

    }
    
    private func animateBase(id: Int, toSelected: Bool, duration: Double, delay: Double) {
        
        guard let toBase = baseLayers[id] else { return }
    
        let fromColor = toSelected ? Color.base : Color.baseSelected
        let toColor = toSelected ? Color.baseSelected : Color.base

        CATransaction.setCompletionBlock {
            toBase.backgroundColor = toColor
        }
        
        let backgroundAnimation = CABasicAnimation(keyPath: #keyPath(CALayer.backgroundColor))
        backgroundAnimation.fromValue = fromColor
        backgroundAnimation.toValue = toColor
        backgroundAnimation.timeOffset = delay
        backgroundAnimation.duration = duration
        
        toBase.add(backgroundAnimation, forKey: #keyPath(CALayer.backgroundColor))

    }
    
}
