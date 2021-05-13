import Foundation

class BallCount {
    private var strike: Int
    private var ball: Int
    
    init() {
        self.strike = 0
        self.ball = 0
    }
    
    func addBall(_ ballType: String) -> (Int, Int) {
        strike += ballType == "S" ? 1 : 0
        ball += ballType == "B" ? 1: 0
        return (strike, ball)
     }
}
