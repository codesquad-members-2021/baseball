//
//  GameList.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import Foundation

struct GameList: Codable, CustomStringConvertible {
    let games: [Game]
}

struct Game: Codable, CustomStringConvertible, Hashable {
    static func == (lhs: Game, rhs: Game) -> Bool {
        return ("\(lhs.myTeam.name):\(lhs.opponentTeam.name)") == ("\(rhs.myTeam.name):\(rhs.opponentTeam.name)")
    }
    
    let myTeam: Team
    let opponentTeam: Team
    let inning: Inning
    let ballCount: BallCount

}

struct BallCount: Codable, CustomStringConvertible, Hashable {
    let strike, ball, out: Int
}

struct Inning: Codable, CustomStringConvertible, Hashable {
    let status: String
    let inningNum: Int
}

struct Team: Codable, CustomStringConvertible, Hashable {
    static func == (lhs: Team, rhs: Team) -> Bool {
        return lhs.name == rhs.name && lhs.players == rhs.players
    }
    
    let name: String
    let score: Int
    let isAttack: Bool
    let players: [Player]
    let currentPitcher, currentBatsman: Player
}

struct Player: Codable, CustomStringConvertible, Hashable {
    let name: String
    let plateAppearance, numberOfPitches, hitsNumbers, accumulatedOutCount: Int
}

extension CustomStringConvertible where Self: Codable {
    var description: String {
        var description = "\(type(of: self)) \n"
        let selfMirror = Mirror(reflecting: self)
        for child in selfMirror.children {
            if let propertyName = child.label {
                description += "\(propertyName): \(child.value)\n"
            }
        }
        return description
    }
}
