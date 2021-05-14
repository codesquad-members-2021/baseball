import Foundation

class BallCount {
    var strikeCount: Int
    var ballCount: Int
    
    init(_ balls: [String]) {
        self.strikeCount = 0
        self.ballCount = 0
        balls.forEach { ball in
            update(with: ball)
        }
    }
    
    convenience init() {
        self.init([])
    }
    
    func update(with ballType: String) {
        strikeCount += ballType == "S" ? 1 : 0
        ballCount += ballType == "B" ? 1: 0
     }
    
    func update(with ballCount: BallCount) {
        self.strikeCount += ballCount.strikeCount
        self.ballCount += ballCount.ballCount
    }
}
