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
        NetworkManager.get(type: GameManager.self, url: EndPoint.url(path: "/1/attack")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { data in
            self.gameManager = data
            self.pitches = self.gameManager.pitchInfo()
        }.store(in: &cancelBag)
    }
    
}
