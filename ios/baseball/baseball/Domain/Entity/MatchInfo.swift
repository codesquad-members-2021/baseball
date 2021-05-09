//
//  MatchInfo.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct MatchInfo: Codable {
    private (set) var scores: Score
    private (set) var strike: Int
    private (set) var ball: Int
    private (set) var outCount: Int
    private (set) var bases: [Bool]
    private (set) var inningInfo: InningInfo
    private (set) var pitcher: Pitcher
    private (set) var batter: Batter
    private (set) var pitcherInfo: [Bool]
    
    init() {
        self.scores = Score(awayScore: 0, homeScore: 0)
        self.strike = 0
        self.ball = 0
        self.outCount = 0
        self.bases = []
        self.inningInfo = InningInfo(inningCount: 0, userTop: false, userOffense: false)
        self.pitcher = Pitcher(name: "", numberOfPitching: 0, hit: 0, baseOnBalls: 0, innings: 0)
        self.batter = Batter(name: "", plateAppearances: 0, hit: 0, out: 0, average: 0.0)
        self.pitcherInfo = []
    }
}
