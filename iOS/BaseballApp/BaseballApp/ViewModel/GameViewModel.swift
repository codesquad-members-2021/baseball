//
//  GameViewModel.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/05.
//

import Foundation

class GameViewModel {
    @Published var game: Game?
    
    let gameUseCase = GameUseCase()
    
    func load() {
        guard let url = Endpoint.url(path: "/room/playInfo") else { return }
        gameUseCase.start(url: url)
    }
    
    func getAwayScore() -> Int {
        return game?.away.score ?? 0
    }
    
    func getHomeScore() -> Int {
        return game?.home.score ?? 0
    }
}
