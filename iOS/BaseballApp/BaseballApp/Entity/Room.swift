//
//  Room.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import Foundation

struct RoomResponse {
    let rooms: [Room]
}

struct Room {
    let id: Int
    let title: String
    let away: String
    let home: String
    let available: Bool
}
