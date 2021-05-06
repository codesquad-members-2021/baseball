//
//  GamePlayViewModel.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation
import Combine

class GamePlayViewModel {
    
    //@Published var gameManager: GameManager!
    @Published var turn: Turn!
    @Published var pitches: [Pitch]!
    @Published var error: Error!
    
    private var cancelBag = Set<AnyCancellable>()
    
    func requestGame() {
        NetworkManager.request(type: GameManager.self, url: EndPoint.url(path: "/1/attack")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { game in
            self.pitches = game.turn.pitches
            self.turn = game.turn
        }.store(in: &cancelBag)
    }
    
}
