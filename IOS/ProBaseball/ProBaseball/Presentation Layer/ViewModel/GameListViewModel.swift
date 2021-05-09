//
//  GameListViewModel.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/09.
//

import Foundation

class GameListViewModel {
    private let gameListUseCase: GameListUseCase
    
    init(gameListUseCase: GameListUseCase) {
        self.gameListUseCase = gameListUseCase
    }
    
    func fetchGameList() {
        self.gameListUseCase.fetchGameList(endpoint: Endpoint.test) { (gameList) in
            print(gameList)
        }
    }
}
