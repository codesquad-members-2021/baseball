//
//  GamePlayViewModel.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation
import Combine

class GamePlayViewModel {
    
    @Published var gameManager: GameManagable!
    @Published var pitches: [Pitch]!
    @Published var error: Error!
    
    private let isUserHomeSide: Bool
    private var cancelBag = Set<AnyCancellable>()
    
    init(_ isUserHomeSide: Bool) {
        self.isUserHomeSide = isUserHomeSide
    }
    
    func requestGame() {
        NetworkManager.request(type: GameManager.self, url: EndPoint.url(path: "/1/attack")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { data in
            self.pitches = data.turn.pitches
            self.gameManager = GameManager(isUserHomeSide: self.isUserHomeSide, turn: data.turn)
        }.store(in: &cancelBag)
    }
    
}
