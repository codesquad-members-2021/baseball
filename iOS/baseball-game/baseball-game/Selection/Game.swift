//
//  Game.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation

struct Game: Hashable, Decodable {
    let id: Int
    let home: Team
    let away: Team
}

struct Team: Hashable, Decodable {
    let team: String
    let status: String
}
