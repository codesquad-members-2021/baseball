//
//  RoundInfo.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

struct RoundInfo: Codable {
    private let round: Int
    private let strike: Int
    private let ball: Int
    private let out: Int
    private let firstBase: Int
    private let secondBase: Int
    private let thirdBase: Int
}
