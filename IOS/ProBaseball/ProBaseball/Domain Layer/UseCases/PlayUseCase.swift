//
//  PlayUseCase.swift
//  ProBaseball
//
//  Created by 오킹 on 2021/05/11.
//

import Foundation
import Combine

class PlayUseCase {
    
    var networkController: NetworkControllerProtocol!
    
    init(networkController: NetworkControllerProtocol) {
        self.networkController = networkController
    }
    
    func fetchGame(endpoint: Endpoint) -> AnyPublisher<Game, NetworkError> {
        return networkController.get(type: Game.self, url: endpoint.url, method: .get)
    }
}
