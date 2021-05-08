//
//  Game.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import Foundation

struct Game: Codable, CustomStringConvertible {
    let myTeam: Team
    let opponentTeam: Team
    let inning: Inning
    let ballCount: BallCount
}

struct BallCount: Codable, CustomStringConvertible {
    let strike, ball, out: Int
}

struct Inning: Codable, CustomStringConvertible {
    let status: String
    let inningNum: Int
}

struct Team: Codable, CustomStringConvertible {
    let name: String
    let score: Int
    let isAttack: Bool
    let players: [Player]
    let currentPitcher, currentBatsman: Player
}

struct Player: Codable, CustomStringConvertible {
    let name: String
    let plateAppearance, numberOfPitches, hitsNumbers, accumulatedOutCount: Int
}


