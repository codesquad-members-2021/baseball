//
//  Game.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import Foundation

struct Game: Codable, CustomStringConvertible, Hashable {
    static func == (lhs: Game, rhs: Game) -> Bool {
        return ("\(lhs.myTeam.name):\(lhs.opponentTeam.name)") == ("\(rhs.myTeam.name):\(rhs.opponentTeam.name)")
    }
    
    let myTeam: Team
    let opponentTeam: Team
    let inning: Inning
    let ballCount: BallCount
}

struct BallCount: Codable, CustomStringConvertible, Hashable {
    let strike, ball, out: Int
}

struct Inning: Codable, CustomStringConvertible, Hashable {
    let status: String
    let inningNum: Int
}


