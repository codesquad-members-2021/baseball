//
//  GameList.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import Foundation

struct GameList: Codable, CustomStringConvertible {
    let games: [Game]
}

extension CustomStringConvertible where Self: Codable {
    var description: String {
        var description = "\n \(type(of: self)) \n"
        let selfMirror = Mirror(reflecting: self)
        for child in selfMirror.children {
            if let propertyName = child.label {
                description += "\(propertyName): \(child.value)\n"
            }
        }
        return description
    }
}
