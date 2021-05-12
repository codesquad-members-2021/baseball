//
//  Inning.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

struct Inning: Decodable {
    
    var counter: Int
    var isTop: Bool
    
    init() {
        self.counter = 1
        self.isTop = true
    }
    
    func isHomeDefense() -> Bool {
        return isTop
    }
    
    enum CodingKeys: String, CodingKey {
        case counter
        case isTop = "top"
    }
    
}

extension Inning: CustomStringConvertible {
    
    var description: String {
        let tail = isTop ? "초" : "말"
        return "\(counter)회 \(tail)"
    }
    
}
