//
//  PlayingTeam.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct PlayingTeam: Codable {
    private let teamName: String
    private let score: Int
    private let picher: Picher
    private let hitter: Hitter
    private let isOffense: Bool
}
