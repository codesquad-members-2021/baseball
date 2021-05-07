//
//  Game.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct Game: Codable {
    private let playTeam: String
    private let roundInfo: RoundInfo
    private let homeTeam: PlayingTeam
    private let awayTeam: PlayingTeam
    private let story: [String]
}
