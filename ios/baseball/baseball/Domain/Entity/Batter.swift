//
//  Batter.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Batter: Codable {
    private (set) var name: String
    private (set) var plateAppearances: Int
    private (set) var hit: Int
    private (set) var out: Int
    private (set) var average: Float
}
