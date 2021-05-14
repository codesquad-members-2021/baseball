//
//  FetchPlayerRecordsUseCase.swift
//  Baseball
//
//  Created by 지북 on 2021/05/13.
//

import Foundation

protocol FetchPlayerRecordsUseCase {
    func execute(about teamName: String, completion: @escaping(Result<[PlayerRecord],NetworkError>) -> Void)
}

class DefaultFetchPlayerRecordsUseCase: FetchPlayerRecordsUseCase {
    private let playerRecordRepository: PlayerRecordRepository
    
    init(playerRecordRepository: PlayerRecordRepository) {
        self.playerRecordRepository = playerRecordRepository
    }
    
    
    func execute(about teamName: String, completion: @escaping (Result<[PlayerRecord], NetworkError>) -> Void) {
        playerRecordRepository.fetchPlayerRecord(about: teamName) { result in
            completion(result)
        }
    }

}
