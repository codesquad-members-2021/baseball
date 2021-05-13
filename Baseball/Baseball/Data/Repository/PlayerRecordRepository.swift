//
//  PlayerRecordRepository.swift
//  Baseball
//
//  Created by 지북 on 2021/05/13.
//

import Foundation
import Combine

protocol PlayerRecordRepository {
    func fetchPlayerRecord(about teamName: String, completion: @escaping (Result<[PlayerRecord], NetworkError>)->Void)
}

class DefaultPlayerRecordRepository: PlayerRecordRepository {
    private let networkService: NetworkService
    private var subscriptions = Set<AnyCancellable>()
    
    init(networkService: NetworkService) {
        self.networkService = networkService
    }
    
    func fetchPlayerRecord(about teamName: String, completion: @escaping (Result<[PlayerRecord], NetworkError>) -> Void) {
        let endpoint = PlayerRecordEndPoint(httpMethod: .get, path: teamName)

        self.networkService.request(with: endpoint, dataType: PlayerRecordDTO.self)
            .sink { result in
                switch result {
                case .failure(let error):
                    print(error)
                    completion(.failure(error))
                case .finished:
                    break
                }
            } receiveValue: { playerRecordDTO in
                let playerRecords = playerRecordDTO.toDomain()
                completion(.success(playerRecords))
            }
            .store(in: &self.subscriptions)
    }
}
