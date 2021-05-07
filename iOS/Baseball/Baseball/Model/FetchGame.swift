//
//  FetchGame.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import Foundation
import Combine

class FetchGame {
    
    private var network: Network
    private var requestable: Requestable
    private var subscriptions = Set<AnyCancellable>()
    
    init() {
        self.network = Network()
        self.requestable = GameAPIEndpoint(path: "", httpMethod: .get)
    }
    
    func fetchGame(completion: @escaping (GameDTO)->Void) {
        network.request(with: requestable, dataType: GameDTO.self)
            .sink { (result) in
                switch result {
                case .failure(let error):
                    print(error)
                case .finished:
                    break
                }
            } receiveValue: { (game) in
                completion(game)
            }
            .store(in: &subscriptions)
    }
}
