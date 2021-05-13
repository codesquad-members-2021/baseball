//
//  GamePlay.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/12.
//

import Foundation

struct GamePlay {
    var matchId: Int
    var away: String
    var home: String
    var inning: Int
    var offenseTeam: String
    var firstBase: [String]
    var secondBase: [String]
    var thirdBase: [String]
    var pitcher: String
    var batter: String
    var strike: Int
    var ball: Int
    var out: Int
    var homePoint: Int
    var awayPoint: Int
}
