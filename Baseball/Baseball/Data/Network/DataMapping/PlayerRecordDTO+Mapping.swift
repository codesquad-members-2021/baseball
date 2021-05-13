//
//  PlayerRecordDTO+Mapping.swift
//  Baseball
//
//  Created by 지북 on 2021/05/13.
//

import Foundation

struct PlayerRecordDTO: Decodable {
    var members: [MembersDTO]
    var teamId: Int
    var teamName: String
    var win: Int
    var lose: Int
    var draw: Int
    var victoryPoint: Int

    struct MembersDTO: Decodable {
        var name: String
        var uniformNumber: Int
        var playedGames: Int
        var atBat: Int
        var hit: Int
        var ball: Int
        var strike: Int
        var battingAverage: String?
        
        func toDomain() -> PlayerRecord {
            return .init(name: name, uniformNumber: uniformNumber, playerGames: playedGames, atBat: atBat, hit: hit, ball: ball, strike: strike)
        }
    }
    func toDomain() -> [PlayerRecord] {
        let records = members.map { record in
            record.toDomain()
        }
        return records
    }
}
