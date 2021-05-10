//
//  FetchGameListUseCase.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/10.
//

import Foundation

protocol FetchGameListUseCase {
    func execute(completion: @escaping([MatchUp]) -> Void)
}

class DefaultFetchGameListUseCase: FetchGameListUseCase {
    private let gameListRepository: GameListRepository
    
    init(gameListRepository: GameListRepository) {
        self.gameListRepository = gameListRepository
    }
    func execute(completion: @escaping ([MatchUp]) -> Void) {
        gameListRepository.fetchGameList { matchUps in
            completion(matchUps)
        }
    }
}
