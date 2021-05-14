//
//  GamePlayRepository.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/12.
//

import Foundation
import Combine

protocol GamePlayRepository {
    func fetchGamePlayData(matchId: Int, completion: @escaping (Result<GamePlay, NetworkError>) -> Void)
}

class DefaultGamePlayRepository: GamePlayRepository {
    
    private let networkService: NetworkService
    private var subscriptions = Set<AnyCancellable>()
    
    init(networkService: NetworkService) {
        self.networkService = networkService
    }
    
    func fetchGamePlayData(matchId: Int, completion: @escaping (Result<GamePlay, NetworkError>) -> Void) {
        let path = String(matchId)
        let endpoint = GamePlayEndPoint(httpMethod: .get, path: path)
        
        self.networkService.request(with: endpoint, dataType: GamePlayDTO.self)
            .sink { result in
                switch result {
                case .failure(let error):
                    completion(.failure(error))
                case .finished:
                    break
                }
            } receiveValue: { gamePlayDTO in
                let gamePlayData = gamePlayDTO.toDomain()
                completion(.success(gamePlayData))
            }
            .store(in: &self.subscriptions)
    }
}
