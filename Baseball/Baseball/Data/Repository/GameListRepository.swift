//
//  GameListRepository.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/10.
//

import Foundation
import Combine

protocol GameListRepository {
    func fetchGameList(completion: @escaping([MatchUp]) -> Void)
}

class DefaultGameListRepository: GameListRepository {
    
    private let networkService: NetworkService
    private var subscriptions = Set<AnyCancellable>()
    
    init(networkService: NetworkService) {
        self.networkService = networkService
    }
    
    func fetchGameList(completion: @escaping ([MatchUp]) -> Void) {
        let endpoint = GameListEndpoint(httpMethod: .get)
        self.networkService.request(with: endpoint, dataType: GameListDTO.self)
            .sink { result in
                switch result {
                case .failure(let error):
                    print(error) // error
                case .finished:
                    break
                }
            } receiveValue: { gameListDTO in
                completion(gameListDTO.toDomain())
            }
            .store(in: &self.subscriptions)
    }
}
