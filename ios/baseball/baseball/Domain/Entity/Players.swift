//
//  Players.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Players: Codable {
    private let pitchers: [Pitcher]
    private let batters: [Batter]
}
