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

struct Team: Codable, Hashable {
    var team: String = ""
    var status: String = ""
}

struct GameInfo: Codable {
    var userID: String = ""
    var gameID: Int = 0
    var team: String = ""
}
