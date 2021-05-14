//
//  DataDTO.swift
//  baseball-game
//
//  Created by Song on 2021/05/12.
//

import Foundation

struct DataDTO<T: Decodable>: Decodable {
    var data: T?
    var error: String?
}
