//
//  Teams.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

struct Teams: Decodable {
    
    var info: [Team]
    
    func find(status: String) -> String {
        let target = info.filter{ $0.status == status }.first!
        return target.team
    }
    
}
