//
//  FetchGamePlayUseCase.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/12.
//

import Foundation

protocol FetchGamePlayUseCase {
    func execute(matchId: Int, completion: @escaping(Result<GamePlay,NetworkError>) -> Void)
}

class DefaultFetchGamePlayUseCase: FetchGamePlayUseCase {
    private let gamePlayRepository: GamePlayRepository
    
    init(gamePlayRepository: GamePlayRepository) {
        self.gamePlayRepository = gamePlayRepository
    }
    
    func execute(matchId : Int, completion: @escaping (Result<GamePlay,NetworkError>) -> Void) {
        gamePlayRepository.fetchGamePlayData(matchId: matchId) { result in
            completion(result)
        }
    }
}
