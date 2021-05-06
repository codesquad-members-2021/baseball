//
//  Game.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation

struct Game: Hashable, Codable {
    let id: Int
    let home: Team
    let away: Team
}

struct Team: Hashable, Codable {
    let team: String
    let status: String
}

struct Info: Codable {
    let userID: String
    let game: Game
}
