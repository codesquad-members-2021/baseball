//
//  Innings.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Innings: Codable {
    private (set) var home: [Int]
    private (set) var away: [Int]
}
