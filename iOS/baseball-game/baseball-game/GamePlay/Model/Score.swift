//
//  Score.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

struct Score: Decodable {
    
    var home: Int
    
    var away: Int
    
    init() {
        self.home = 0
        self.away = 0
    }
    
}
