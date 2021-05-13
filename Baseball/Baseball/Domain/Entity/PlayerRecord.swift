//
//  PlayerRecord.swift
//  Baseball
//
//  Created by 지북 on 2021/05/13.
//

import Foundation

struct PlayerRecord {
    let name: String
    let uniformNumber: Int
    let playerGames: Int
    let atBat: Int
    let hit: Int
    let ball: Int
    let strike: Int
    var battingAverage: Double {
        return round((Double(hit) / Double(atBat)) * 100)
    }
}
