//
//  BallCounter.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

struct BallChanged: Decodable {
    var strike: Int
    var ball: Int
    var out: Int
}

class BallCounter {
    
    private var strike: Int
    private var ball: Int
    private var out: Int
    
    init(strike: Int, ball: Int, out: Int) {
        self.strike = strike
        self.ball = ball
        self.out = out
    }
    
    convenience init() {
        self.init(strike: 0, ball: 0, out: 0)
    }
    
    func reset() {
        self.strike = 0
        self.ball = 0
        self.out = 0
    }
    
    func update(with newInfo: BallChanged) {
        updateStrike(newInfo.strike)
        updateBall(newInfo.ball)
        updateOut(newInfo.out)
    }
    
    static let notiName = Notification.Name.init("ballCountChanged")
    
    private func updateStrike(_ count: Int) {
        self.strike += count

        let updateInfo: [String: Any] = ["ballType": BallCount.strike, "count": self.strike]
        NotificationCenter.default.post(name: BallCounter.notiName, object: nil, userInfo: updateInfo)
    }
    
    private func updateBall(_ count: Int) {
        self.ball += count
        
        let updateInfo: [String: Any] = ["ballType": BallCount.ball, "count": self.ball]
        NotificationCenter.default.post(name: BallCounter.notiName, object: nil, userInfo: updateInfo)
    }
    
    private func updateOut(_ count: Int) {
        self.out += count
        
        let updateInfo: [String: Any] = ["ballType": BallCount.out, "count": self.out]
        NotificationCenter.default.post(name: BallCounter.notiName, object: nil, userInfo: updateInfo)
    }
    
}

enum BallCount {
    case strike
    case ball
    case out
}
