//
//  Game.swift
//  baseball-game
//
//  Created by Song on 2021/05/04.
//

import Foundation

struct Game: Decodable {
    
    var inning: [Int] //2회말:[2,2] / 7회초:[7,1]
    
    var home: Team
    
    var away: Team
    
    struct Team: Decodable {
        
        var name: String //Marvel
        
        var score: Int //5
        
        var role: String //offense나 defense
        
        var player: Player
        
        struct Player: Decodable {
            
            var position: String //batter나 pitcher
            
            var name: String
            
            var info: String //#39, 1타석 0안타 등
            
        }
    }
    
    var ballCounts: [Int] //Strike-Ball-Out 순서 [0, 1, 2]
    
    var baseInfo: [Bool] //3루에만 주자가 있는 경우 [false, false, true]
    
    var pitches: [Pitch]
    
    struct Pitch: Decodable {
        
        var result: String
        
        var log: String
        
    }
}
