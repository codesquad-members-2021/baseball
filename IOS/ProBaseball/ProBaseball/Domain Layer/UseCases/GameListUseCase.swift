//
//  GameInfoUseCase.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation
import Combine

protocol GameListUseCaseProtocol {
    func fetchGameList(endpoint: Endpoint) -> AnyPublisher<GameList, NetworkError>
}

class GameListUseCase: GameListUseCaseProtocol {
    let networkController: NetworkControllerProtocol
    
    init(networkController: NetworkControllerProtocol) {
        self.networkController = networkController
    }
    
    func fetchGameList(endpoint: Endpoint) -> AnyPublisher<GameList, NetworkError> {
        return networkController.get(type: GameList.self, url: endpoint.url, method: .get)
    }
}
