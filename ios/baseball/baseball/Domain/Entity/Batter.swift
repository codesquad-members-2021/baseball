//
//  Batter.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Batter: Codable {
    private let name: String
    private let plateAppearances: Int
    private let hit: Int
    private let out: Int
    private let average: Float
}
