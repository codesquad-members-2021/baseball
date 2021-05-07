//
//  GameViewModel.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import Foundation

class GameViewModel {
    
    @Published var game: Game!
    private var fetchGame: FetchGame
    
    init(fetchgame: FetchGame) {
        self.fetchGame = FetchGame()
        fetchGameViewModel()
    }
    
    func fetchGameViewModel() {
        fetchGame.fetchGame(completion: { result in
            self.game = result.game
        })
    }
}
