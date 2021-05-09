//
//  Player.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation

struct Player: Codable, CustomStringConvertible {
    let name: String
    let plateAppearance, numberOfPitches, hitsNumbers, accumulatedOutCount: Int
}
