//
//  RoomsViewModel.swift
//  BaseballApp
//
//  Created by Song on 2021/05/05.
//

import Foundation

class RoomsViewModel {
    @Published var rooms: RoomResponse = RoomResponse(rooms: [])
    let roomsUseCase = RoomsUseCase()
    
    func load() {
        guard let url = Endpoint.url(path: "/room/list") else { return }
        roomsUseCase.start(url: url)
    }
}
