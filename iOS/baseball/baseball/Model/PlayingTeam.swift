//
//  PlayingTeam.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct PlayingTeam: Codable {
    let teamName: String
    let score: Int
    let picher: Picher
    let hitter: Hitter
    let isOffense: Bool
}
