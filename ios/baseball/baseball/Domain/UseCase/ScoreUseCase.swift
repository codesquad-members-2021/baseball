//
//  ScoreUseCase.swift
//  baseball
//
//  Created by zombietux on 2021/05/10.
//

import Foundation
import RxSwift

class ScoreUseCase: UseCasePort {
    private var networkService: NetworkServiceable
    
    init(networkService: NetworkServiceable = NetworkService()) {
        self.networkService = networkService
    }
    
    func get<T>(path: APIPath, id: String?) -> Observable<T> where T : Decodable, T : Encodable {
        return networkService.get(path: .gameInfo, id: id)
    }
}

