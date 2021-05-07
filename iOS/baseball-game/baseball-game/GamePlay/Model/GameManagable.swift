//
//  GameManagable.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation

protocol GameManagable {
    
    func teamInfo() -> [String: String]
    
    func scoreInfo() -> [String: Int]
    
    func inningInfo() -> String

    func pitcherInfo() -> Player
    
    func batterInfo() -> Player
    
    func pitchInfo() -> [Pitch]
    
    func isUserDefense() -> Bool?
    
}
