//
//  PlayUseCase.swift
//  baseball
//
//  Created by zombietux on 2021/05/09.
//

import Foundation
import RxSwift
import RxCocoa

protocol PlayUseCasePort {
    func get(path: APIPath, id: String?) -> Observable<MatchInfo>
}

class PlayUseCase: PlayUseCasePort {
    private var networkService: NetworkServiceable
    
    init(networkService: NetworkServiceable = NetworkService()) {
        self.networkService = networkService
    }
    
    func get(path: APIPath, id: String?) -> Observable<MatchInfo> {
        return networkService.get(path: .progress, id: id)
    }
}
