//
//  GameEntity.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import Foundation

struct GameList: Decodable {
    var gameNumber: Int
    var home: String
    var away: String
}

struct Game: Decodable {
    var home: Team
    var away: Team
    var homeScore: Int
    var awayScore: Int
    var inning: Int // 몇회
    var status: String // 초, 말
    var ballCount: [BallCount]
}

struct Team: Decodable {
    var name: String
    var players: [Player]
}

struct Player: Decodable {
    var name: String
    var position: String // 포지션
    var atBat: String // 타석
    var hits: Int // 안타
    var out: Int // 아웃
    var battingAverage: Double // 타율
    var numberOfPitches: Int // 투구수
}

struct BallCount: Decodable {
    enum ball: Int, Decodable {
        case strike = 0
        case ball = 1
        case hit = 2
    }
    var ballCount: [ball]
    var hit: Bool
}

struct Score {
    var home: [Int]
    var away: [Int]
}
