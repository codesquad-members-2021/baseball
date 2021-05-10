//
//  ScoreUseCase.swift
//  baseball
//
//  Created by zombietux on 2021/05/10.
//

import Foundation
import RxSwift

protocol ScoreUseCasePort {
    func get(path: APIPath, id: String?) -> Observable<GameInfo>
}

class ScoreUseCase: ScoreUseCasePort {
    private var networkService: NetworkServiceable
    
    init(networkService: NetworkServiceable = NetworkService()) {
        self.networkService = networkService
    }
    
    func get(path: APIPath, id: String?) -> Observable<GameInfo> {
        return networkService.get(path: .gameInfo, id: id)
    }
}

