//
//  Turn.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation

struct Turn: Decodable {
    
    var inning: [Int]
    
    var home: Team
    
    var away: Team
    
    struct Team: Decodable {
        
        var name: String
        
        var score: Int
        
        var role: String
        
        var player: Player
        
        enum CodingKeys: String, CodingKey {
            case name = "team"
            case score
            case role
            case player
        }
    }
    
    var ballCounts: [Int]
    
    var baseInfo: [Bool]
    
    var pitches: [Pitch]
    
    enum CodingKeys: String, CodingKey {
        case inning
        case home
        case away
        case ballCounts
        case baseInfo
        case pitches = "list"
    }
}
