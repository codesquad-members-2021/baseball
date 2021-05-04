//
//  PlayerScoreBoard.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct PlayerScoreBoard: Codable {
    let id: Int
    let name: String
    let TPA: Int
    let hits: Int
    let out: Int
}
