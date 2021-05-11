//
//  ScoreUseCase.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/11.
//

import Foundation
import Combine

protocol ScoreUseCaseProtocol {
    func fetchGameInformation(endpoint: Endpoint) -> AnyPublisher<Game, NetworkError>
}

class ScoreUseCase: ScoreUseCaseProtocol {
    let networkController: NetworkControllerProtocol
    
    init(networkController: NetworkControllerProtocol) {
        self.networkController = networkController
    }
    
    func fetchGameInformation(endpoint: Endpoint) -> AnyPublisher<Game, NetworkError> {
        return networkController.get(type: Game.self, url: endpoint.url, method: .get)
    }
}
