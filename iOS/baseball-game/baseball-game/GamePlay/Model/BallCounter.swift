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
    
    static let notiName = Notification.Name.init("ballCountChanged")
    
    enum UserInfo {
        static let ballType = "ballType"
        static let count = "count"
    }
    
    func reset() {
        self.strike = 0
        self.ball = 0
        self.out = 0
        
        notiBallChange(ballType: BallCount.strike, count: self.strike)
        notiBallChange(ballType: BallCount.ball, count: self.ball)
        notiBallChange(ballType: BallCount.out, count: self.out)
    }
    
    private func notiBallChange(ballType: BallCount, count: Int) {
        let updateInfo: [String: Any] = ["ballType": ballType, "count": count]
        NotificationCenter.default.post(name: BallCounter.notiName, object: nil, userInfo: updateInfo)
    }
    
    func update(with newInfo: BallChanged) {
        updateStrike(newInfo.strike)
        updateBall(newInfo.ball)
        updateOut(newInfo.out)
    }
    
    private func updateStrike(_ count: Int) {
        self.strike += count

        notiBallChange(ballType: BallCount.strike, count: self.strike)
        if self.strike == 3 { self.strike = 0 }
    }
    
    private func updateBall(_ count: Int) {
        self.ball += count

        notiBallChange(ballType: BallCount.ball, count: self.ball)
        if self.ball == 4 { self.ball = 0 }
    }
    
    private func updateOut(_ count: Int) {
        self.out += count
        
        notiBallChange(ballType: BallCount.out, count: self.out)
        if self.out == 3 { self.out = 0 }
    }
    
}

enum BallCount {
    case strike
    case ball
    case out
}
