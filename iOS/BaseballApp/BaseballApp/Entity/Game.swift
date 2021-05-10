//
//  Game.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import Foundation

struct GameResponse: Decodable {
    let data: Game
}

struct Game: Decodable {
    let strike: Int
    let ball: Int
    let out: Int
    let away_team: Team
    let home_team: Team
    let inning: String
    let halves: String
    let pitcher: Player
    let pitcher_status: String
    let batter: Player
    let batter_status: String
    let base1: String?
    let base2: String?
    let base3: String?
    let pitch_histories: [Record]
    let my_role: String
}

struct Player: Decodable {
    let team_id: Int
    let uniform_number: Int
    let name: String
}

struct Record: Decodable {
    let pitcher: Player
    let batter: Player
    let result: String
    let strike_count: Int
    let ball_count: Int
}

struct Team: Decodable {
    let name: String
    let score: Int
    let role: String
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
