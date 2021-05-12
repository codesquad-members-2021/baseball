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
    let awayTeam: Team
    let homeTeam: Team
    let inning: String
    let halves: String
    let pitcher: Player
    let pitcherStatus: String
    let batter: Player
    let batterStatus: String
    let base1: String?
    let base2: String?
    let base3: String?
    let pitchHistories: [Record]
    let myRole: String
    
    enum CodingKeys: String, CodingKey {
        case strike, ball, out, inning, halves, pitcher, batter, base1, base2, base3
        case awayTeam = "away_team"
        case homeTeam = "home_team"
        case pitcherStatus = "pitcher_status"
        case batterStatus = "batter_status"
        case pitchHistories = "pitch_histories"
        case myRole = "my_role"
    }
}

struct Player: Decodable {
    let teamId: Int
    let uniformNumber: Int
    let name: String
    
    enum CodingKeys: String, CodingKey {
        case name
        case teamId = "team_id"
        case uniformNumber = "uniform_number"
    }
}

struct Record: Decodable {
    let pitcher: Player
    let batter: Player
    let result: String
    let strikeCount: Int
    let ballCount: Int
    
    enum CodingKeys: String, CodingKey {
        case pitcher, batter, result
        case strikeCount = "strike_count"
        case ballCount = "ball_count"
    }
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
