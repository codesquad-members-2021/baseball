//
//  Game.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import Foundation

struct Game {
    let myTeam: Team
    let opponentTeam: Team
    let inning: Inning
    let ballCount: BallCount
}

struct Inning {
    var status: String
    var inningNum: Int
}

struct Team {
    var score: Int
    var isAttack: Bool
    var players: [Player]
    var currentPitcher: Player
    var currentBatsman: Player
}

struct Player {
    let name: String
    var plateAppearance: Int
    var numberOfPitches: Int
    var hitsNumber: Int
    var accumulatedOutCount: Int
}

struct BallCount {
    let strike: Int
    let ball: Int
    let out: Int
}
