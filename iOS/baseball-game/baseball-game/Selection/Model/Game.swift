//
//  Game.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation

struct Game: Codable, Hashable {
    var id: Int = 0
    var home: Team = Team()
    var away: Team = Team()
}
