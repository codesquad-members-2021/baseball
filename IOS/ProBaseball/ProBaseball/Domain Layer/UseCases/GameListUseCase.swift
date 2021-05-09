//
//  GameInfoUseCase.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation
import Combine

protocol GameListUseCaseProtocol {
    func fetchGameList(endpoint: Endpoint, completion: ([Game]) -> Void)
}

class GameListUseCase: GameListUseCaseProtocol {
    let gameListRepository: GameListRepository
    
    init(gameListRepository: GameListRepository) {
        self.gameListRepository = gameListRepository
    }
    
    func fetchGameList(endpoint: Endpoint, completion: ([Game]) -> Void) {
        gameListRepository.fetchGameList(endpoint: endpoint) { (gameArray) in
            completion(gameArray)
        }
    }
}
