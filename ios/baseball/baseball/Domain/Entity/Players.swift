//
//  Players.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/07.
//

import Foundation

struct Players: Codable {
    private(set) var pitchers: [Pitcher]
    private(set) var batters: [Batter]
    
    init() {
        self.pitchers = []
        self.batters = []
    }
}
