import UIKit

class BallCountView: UIView {
    private lazy var strikePoint = CGPoint(x: 20, y: 2)
    private lazy var ballPoint = CGPoint(x: 20, y: 26)
    private lazy var outPoint = CGPoint(x: 20, y: 50)
    private let rectSize = CGSize(width: 20, height: 20)
    private var strikeCount: Int = 0
    private var ballCount: Int = 0
    private var outCount: Int = 0
    
    func configure(strikeCount: Int, ballCount: Int, outCount: Int) {
        self.strikeCount = strikeCount
        self.ballCount = ballCount
        self.outCount = outCount
    }
    
    func initializePosition() {
        strikePoint = CGPoint(x: 20, y: 2)
        ballPoint = CGPoint(x: 20, y: 26)
        outPoint = CGPoint(x: 20, y: 50)
    }
    
    
    override func draw(_ rect: CGRect) {
        guard let context = UIGraphicsGetCurrentContext() else { return }
        context.setStrokeColor(UIColor.gray.cgColor)
        for _ in 0..<strikeCount {
            drawStrike(context)
        }
        for _ in 0..<ballCount {
            drawBall(context)
        }
        for _ in 0..<outCount {
            drawOut(context)
        }
    }

    func drawStrike(_ context: CGContext) {
        context.setFillColor(UIColor.yellow.cgColor)
        context.addEllipse(in: CGRect(origin: strikePoint, size: rectSize))
        context.closePath()
        context.drawPath(using: .fillStroke)
        strikePoint.x += 25
    }
    
    func drawBall(_ context: CGContext) {
        context.setFillColor(UIColor.green.cgColor)
        context.addEllipse(in: CGRect(origin: ballPoint, size: rectSize))
        context.closePath()
        context.drawPath(using: .fillStroke)
        ballPoint.x += 25
    }
    
    func drawOut(_ context: CGContext) {
        context.setFillColor(UIColor.red.cgColor)
        context.addEllipse(in: CGRect(origin: outPoint, size: rectSize))
        context.closePath()
        context.drawPath(using: .fillStroke)
        outPoint.x += 25
    }

}
