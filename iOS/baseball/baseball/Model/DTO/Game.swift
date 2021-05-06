//
//  Game.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct Game: Codable {
    let playTeam: String
    let roundInfo: RoundInfo
    let homeTeam: PlayingTeam
    let awayTeam: PlayingTeam
    let story: [String]
}
