//
//  Game.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import Foundation

struct Game {
    let home: Team
    let away: Team
    let strike: Int
    let ball: Int
    let out: Int
    let inning: String
    let myRole: String
    let base1: String?
    let base2: String?
    let base3: String?
    
    enum CodingKeys: String, CodingKey {
        case home, away, strike, ball, out
        case inning = "stage"
        case myRole = "myRule"
        case base1, base2, base3
    }
}

struct Team {
    let name: String
    let score: Int
    let position: String
    let player: String
    let playerStatus: String
}

struct GameHistory {
    let home: TeamHistory
    let away: TeamHistory
    let inning: String
}

struct TeamHistory {
    let name: String
    let total: Int
    let scores: [Int]
    let battingStatics: [PlayerInformation] // 타율 리스트
}

struct PlayerInformation {
    let id: Int
    let name: String
    let plateAppearance: Int // 타석
    let hits: Int // 안타
    let out: Int
    let average: Float
    let isPlaying: Bool
}
