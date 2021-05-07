//
//  GameInfo.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct GameInfo: Codable {
    private let scores: Score
    private let innings: Innings
    private let awayPlayers: Players
    private let homePlayers: Players
}
