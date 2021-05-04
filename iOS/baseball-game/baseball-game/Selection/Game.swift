//
//  Game.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation

struct Game: Hashable {
    let id: Int
    let home: String
    let away: String
    let selectable: Bool
}


let game1 = Game(id: 1, home: "Marvel", away: "Captin", selectable: true)
let game2 = Game(id: 2, home: "Tigers", away: "Twins", selectable: false)
let game3 = Game(id: 3, home: "Dodgers", away: "Rockets", selectable: false)
let game4 = Game(id: 4, home: "Pintos", away: "Heros", selectable: false)
let game5 = Game(id: 5, home: "LiaTigers", away: "LolloTwins", selectable: true)
let game6 = Game(id: 6, home: "Shion", away: "KalTwoi", selectable: true)

let games = [game1, game2, game3, game4, game5, game6]
