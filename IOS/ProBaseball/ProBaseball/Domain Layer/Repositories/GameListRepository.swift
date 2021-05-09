//
//  GameListRepository.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation
import Combine

protocol GameListRepositoryProtocol {
    func fetchGameList(endpoint: Endpoint, completion:([Game]) -> Void)
}

class GameListRepository: GameListRepositoryProtocol {
    var gameRepository: [Game] = []
    let networkController: NetworkControllerProtocol
    var subscriptions = Set<AnyCancellable>()
    
    init(networkController: NetworkControllerProtocol) {
        self.networkController = networkController
    }
    
    func fetchGameList(endpoint: Endpoint, completion: ([Game]) -> Void) {
        networkController.get(type: GameList.self, url: endpoint.url, headers: endpoint.headers).sink { (completion) in
            switch completion {
            case .failure(let error):
                print(error)
            case .finished:
                break
            }
        } receiveValue: { (gameList) in
            print(gameList.games[0])
        }.store(in: &subscriptions)
    }
}
