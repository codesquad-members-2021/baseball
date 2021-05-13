//
//  GamePlayDTO+Mapping.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/12.
//

import Foundation

/*
 {"matchId":13,
 "away":"awayteam to string",
 "home":"hometeam to string",
 "inning":1,
 "offenseTeam":"offenseTeam to String"
 "firstBase":[],
 "secondBase":[],
 "thirdBase":[],
 "pitcher":"kim",
 "batter":"dong",
 "strike":0,
 "ball":0,
 "out":0,
 "homePoint":0,
 "awayPoint":0}
 */



struct GamePlayDTO: Decodable {
    private let matchId: Int
    private let away: String
    private let home: String
    private let inning: Int
    private let offenseTeam: String
    private let firstBase: [String]
    private let secondBase: [String]
    private let thirdBase: [String]
    private let pitcher: String
    private let batter: String
    private let strike: Int
    private let ball: Int
    private let out: Int
    private let homePoint: Int
    private let awayPoint: Int
    
    func toDomain() -> GamePlay {
        return .init(matchId: matchId, away: away, home: home, inning: inning, offenseTeam: offenseTeam, firstBase: firstBase, secondBase: secondBase, thirdBase: thirdBase, pitcher: pitcher, batter: batter, strike: strike, ball: ball, out: out, homePoint: homePoint, awayPoint: awayPoint)
    }
}
