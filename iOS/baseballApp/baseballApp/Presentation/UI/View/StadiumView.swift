import UIKit

class StadiumView: UIView {
    private lazy var flag = false
    private lazy var height = self.bounds.height
    private lazy var width = self.bounds.width
    private lazy var baseInterval = Float(width)/3.3
    private lazy var baseSize: Float = 15.0
   
    private lazy var fieldCenter = CGPoint(x: bounds.midX, y: bounds.midY)

    private lazy var homeBase = CGPoint(x: fieldCenter.x, y: fieldCenter.y + CGFloat(baseInterval))
    private lazy var firstBase = CGPoint(x: fieldCenter.x + CGFloat(baseInterval), y: fieldCenter.y)
    private lazy var secondBase =  CGPoint(x: fieldCenter.x, y: fieldCenter.y - CGFloat(baseInterval))
    private lazy var thirdBase = CGPoint(x: fieldCenter.x - CGFloat(baseInterval), y: fieldCenter.y)
    private lazy var basePoints = [homeBase, firstBase, secondBase, thirdBase]
    private lazy var preBaseStatus = [Int]()
    
    private lazy var isFirstBaseFilled = false
    private lazy var isSecondBaseFilled = false
    private lazy var isThirdBaseFilled = false
    
    private lazy var isHomePlayer = false
    private lazy var isFirstPlayer = false
    private lazy var isSecondPlayer = false
    private lazy var isThirdPlayer = false
    
    
    override func draw(_ rect: CGRect) {
        let context = UIGraphicsGetCurrentContext()!
        drawField(context)
        context.setFillColor(UIColor.yellow.cgColor)
        drawBaseStatus(context)
        if flag {
            fetchPlayer(preBaseStatus)
        }
    }
       
    private func drawField(_ context: CGContext) {
        context.setStrokeColor(UIColor.gray.cgColor)
        context.setLineWidth(4.0)
        drawRotatedRect(context, center: fieldCenter, length: baseInterval, mode: .stroke)
        context.setFillColor(UIColor.white.cgColor)
        context.setLineWidth(1.0)
        drawBase(context)
    }
    
    private func drawBase(_ context: CGContext) {
        drawHomeBase(context, center: homeBase)
        drawRotatedRect(context, center: firstBase, length: baseSize, mode: .fillStroke)
        drawRotatedRect(context, center: secondBase, length: baseSize, mode: .fillStroke)
        drawRotatedRect(context, center: thirdBase, length: baseSize, mode: .fillStroke)
    }
    
    private func drawRotatedRect(_ context: CGContext, center: CGPoint, length: Float, mode: CGPathDrawingMode) {
        let points = [
            CGPoint(x: center.x, y: center.y + CGFloat(length)),
            CGPoint(x: center.x + CGFloat(length), y: center.y),
            CGPoint(x: center.x, y: center.y - CGFloat(length)),
            CGPoint(x: center.x - CGFloat(length), y: center.y)
        ]
        context.addLines(between: points)
        context.closePath()
        context.drawPath(using: mode)
    }
    
    private func fillRotatedRect(_ context: CGContext, center: CGPoint) {
        let length = baseSize
        let points = [
            CGPoint(x: center.x, y: center.y + CGFloat(length)),
            CGPoint(x: center.x + CGFloat(length), y: center.y),
            CGPoint(x: center.x, y: center.y - CGFloat(length)),
            CGPoint(x: center.x - CGFloat(length), y: center.y)
        ]
        context.addLines(between: points)
        context.closePath()
        context.drawPath(using: .fillStroke)
    }

    private func drawHomeBase(_ context: CGContext, center: CGPoint) {
        let length = CGFloat(width / 20)
        let path = UIBezierPath()
        let points = [
            CGPoint(x: center.x + length, y: center.y),
            CGPoint(x: center.x + length, y: center.y + length * 2),
            CGPoint(x: center.x - length, y: center.y + length * 2),
            CGPoint(x: center.x - length, y: center.y ),
        ]
        path.move(to: CGPoint(x: center.x, y: center.y - length))
        points.forEach { point in
            path.addLine(to: point)
        }
        path.close()
        path.fill()
        path.stroke()
    }
}

extension StadiumView {
    func configure(_ baseStatus: [Int]) {
        baseStatus.forEach { status in
            switch status {
            case 1: isFirstBaseFilled = true
            case 2: isSecondBaseFilled = true
            case 3: isThirdBaseFilled = true
            default: break
            }
        }
    }
    
    private func drawBaseStatus(_ context: CGContext) {
        if isFirstBaseFilled {
            fillRotatedRect(context, center: firstBase)
        }
        if isSecondBaseFilled {
            fillRotatedRect(context, center: secondBase)
        }
        if isThirdBaseFilled {
            fillRotatedRect(context, center: thirdBase)
        }
    }
    
    func initializeBase() {
        isFirstBaseFilled = false
        isSecondBaseFilled = false
        isThirdBaseFilled = false
    }
}

extension StadiumView {
    
    func acivateAnimation() {
        flag = true
    }
    
    func PreBaseStatus(_ playersStatus: [Int]) {
        self.preBaseStatus = playersStatus
    }
    
    func fetchPlayer(_ playersStatus: [Int]) {
        drawPlayer(from: 0)
        playersStatus.forEach { status in
            drawPlayer(from: status)
        }
    }

    private func drawPlayer(from position: Int) {
        let playerLayer = CALayer()
        layer.backgroundColor = UIColor.red.cgColor
        playerLayer.frame = CGRect(origin: basePoints[position], size: CGSize(width: 10, height: 10))
        self.layer.addSublayer(playerLayer)
        
        let animation = CABasicAnimation(keyPath: "position")
        animation.fromValue = basePoints[position]
        if position == 3 {
            animation.toValue = basePoints[0]
        } else {
            animation.toValue = basePoints[position + 1]
        }
        animation.duration = 1
        animation.fillMode = .forwards
        animation.isRemovedOnCompletion = false
        animation.beginTime = CACurrentMediaTime()
        playerLayer.add(animation, forKey: nil)
    }
}

