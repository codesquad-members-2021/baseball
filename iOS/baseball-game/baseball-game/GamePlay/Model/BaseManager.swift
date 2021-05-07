//
//  BaseManager.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

class BaseManager: Decodable {
    
    var first: Bool
    
    var second: Bool
    
    var third: Bool
    
    init(first: Bool, second: Bool, third: Bool) {
        self.first = first
        self.second = second
        self.third = third
    }
    
    convenience init() {
        self.init(first: false, second: false, third: false)
    }
    
    //변경하는 메소드
}
