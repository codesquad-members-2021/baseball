//
//  GameInfo.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct GameInfo: Codable {
    private(set) var scores: Score
    private(set) var innings: Innings
    private(set) var awayPlayers: Players
    private(set) var homePlayers: Players
    
    init() {
        self.scores = Score(awayScore: 0, homeScore: 0)
        self.innings = Innings(home: [], away: [])
        self.awayPlayers = Players()
        self.homePlayers = Players()
    }
}
