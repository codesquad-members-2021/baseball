//
//  BaseballGameDTO.swift
//  baseball
//
//  Created by 박정하 on 2021/05/06.
//

import Foundation

struct GameDTO: Decodable {
    let homeTeam: TeamDTO
    let awayTeam: TeamDTO
    
    let inning: Int
    let state: String
    let batter: Int
    let strike: Int
    let ball: Int
    let out: Int
    
    let baseState: [Bool]
    let history: [PitchingHistory]
    let inningScore: InningScore
}
