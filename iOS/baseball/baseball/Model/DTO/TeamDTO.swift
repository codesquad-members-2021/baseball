//
//  Team.swift
//  baseball
//
//  Created by 박정하 on 2021/05/06.
//

import Foundation

struct TeamDTO: Decodable {
    let name: String
    let score: Int
    let player: [Player]
    let pitcher: Pitcher
}
