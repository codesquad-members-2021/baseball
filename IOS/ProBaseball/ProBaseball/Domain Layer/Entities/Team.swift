//
//  Team.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation

struct Team: Codable, CustomStringConvertible {
    let name: String
    let score: Int
    let isAttack: Bool
    let players: [Player]
    let currentPitcher, currentBatsman: Player
}
