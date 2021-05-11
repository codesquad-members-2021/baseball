//
//  GameListSceneDIContainer.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/09.
//

import Foundation

final class GameListSceneDIContainer {
    func makeGameListUseCase() -> GameListUseCase {
        return GameListUseCase(networkController: NetworkController())
    }

    func makeGameListViewModel() -> GameListViewModel {
        return GameListViewModel(gameListUseCase: makeGameListUseCase())
    }
}
