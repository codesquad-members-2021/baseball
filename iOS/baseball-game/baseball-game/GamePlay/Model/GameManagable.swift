//
//  GameManagable.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation

protocol GameManagable {
    func teams() -> [String: String]
    func scores() -> [String: Int]
    func inning() -> String
    func pitcher() -> Player
    func batter() -> Player
    func isUserDefense() -> Bool?
}
