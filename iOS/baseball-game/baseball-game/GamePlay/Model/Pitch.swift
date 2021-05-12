//
//  Pitch.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation

struct Pitch: Decodable, Hashable {
    let id = UUID()
    var count: Int
    var result: String
    var log: String
    
    enum CodingKeys: String, CodingKey {
        case count, result, log
    }
}
