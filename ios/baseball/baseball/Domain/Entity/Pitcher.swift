//
//  Pitcher.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Pitcher: Codable {
    private (set) var name: String
    private (set) var numberOfPitching: Int
    private (set) var hit: Int
    private (set) var baseOnBalls: Int
    private (set) var innings: Int
}
