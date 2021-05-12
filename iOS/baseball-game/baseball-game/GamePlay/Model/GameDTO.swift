//
//  GameDTO.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

struct GameDTO: Decodable {
    
    var teams: Teams?
    var inning: Inning?
    var score: Score?
    var batter: Player?
    var pitcher: Player?
    var newPitch: Pitch?
    var ballChanged: BallChanged?
    var baseChanged: BaseChanged?

    enum CodingKeys: String, CodingKey {
        case teams
        case inning
        case score
        case batter
        case pitcher
        case newPitch = "new-pitch"
        case ballChanged = "ball-changed"
        case baseChanged = "base-changed"
    }
    
}
