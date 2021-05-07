//
//  Pitcher.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Pitcher: Codable {
    private let name: String
    private let numberOfPitching: Int
    private let hit: Int
    private let baseOnBalls: Int
    private let innings: Int
}
