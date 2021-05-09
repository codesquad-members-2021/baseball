//
//  GameListSceneDIContainer.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/09.
//

import Foundation

final class GameListSceneDIContainer {
    func makeGameListRepository() -> GameListRepository {
        return GameListRepository(networkController: NetworkController())
    }
    
    func makeGameListUseCase() -> GameListUseCase {
        return GameListUseCase(gameListRepository: makeGameListRepository())
    }

    func makeGameListViewModel() -> GameListViewModel {
        return GameListViewModel(gameListUseCase: makeGameListUseCase())
    }
}
