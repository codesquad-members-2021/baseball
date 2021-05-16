//
//  Collection Extension.swift
//  baseball-game
//
//  Created by Song on 2021/05/16.
//

import Foundation

extension Collection {
    
    subscript(safe index: Index) -> Element? {
        return indices.contains(index) ? self[index] : nil
    }
    
}
