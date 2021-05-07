//
//  BallCounter.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

class BallCounter: Decodable {
    
    var strike: Int
    
    var ball: Int
    
    var out: Int
    
    init(strike: Int, ball: Int, out: Int) {
        self.strike = strike
        self.ball = ball
        self.out = out
    }
    
    convenience init() {
        self.init(strike: 0, ball: 0, out: 0)
    }
    
    //더하는 메소드
}
