//
//  MatchInfo.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct MatchInfo: Codable {
    private let scores: Score
    private let strike: Int
    private let ball: Int
    private let outCount: Int
    private let bases: [Bool]
    private let inningInfo: String
    private let pitcher: Pitcher
    private let batter: Batter
    private let pitcherInfo: [Bool]
}
