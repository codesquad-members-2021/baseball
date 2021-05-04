//
//  RoundInfo.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct RoundInfo: Codable {
    let round: Int
    let strike: Int
    let ball: Int
    let out: Int
    let firstBase: Int
    let secondBase: Int
    let thirdBase: Int
}
