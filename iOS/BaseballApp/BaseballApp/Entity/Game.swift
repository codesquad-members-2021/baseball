//
//  Game.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import Foundation

struct Game: Decodable {
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
    let pitcherHistory: [Record]
}

struct Record: Decodable {
    let result: String
    let pitchStrikeCount: String
    
    enum CodingKeys: String, CodingKey {
        case result
        case pitchStrikeCount = "log"
    }
}

struct Team: Decodable {
    let name: String
    let score: Int
    let position: String
    let player: String
    let playerStatus: String
}

struct Scoreboard: Decodable {
    let home: Score
    let away: Score
    let inning: String
}

struct Score: Decodable {
    let teamName: String
    let total: Int
    let scores: [Int]
    let battingStats: [HitterInformation]
}

struct HitterInformation: Decodable {
    let id: Int
    let name: String
    let plateAppearance: Int
    let hits: Int
    let out: Int
    let average: Float
    let isPlaying: Bool
}
