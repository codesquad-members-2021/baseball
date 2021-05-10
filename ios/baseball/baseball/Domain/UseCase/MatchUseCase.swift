//
//  MatchUseCase.swift
//  baseball
//
//  Created by zombietux on 2021/05/07.
//

import Foundation
import RxSwift

protocol MatchUseCasePort {
    func get(path: APIPath, id: String?) -> Observable<[Match]>
}

class MatchUseCase: MatchUseCasePort {
    private var networkService: NetworkServiceable
    
    init(networkService: NetworkServiceable = NetworkService()) {
        self.networkService = networkService
    }
    
    func get(path: APIPath, id: String?) -> Observable<[Match]> {
        return networkService.get(path: .match, id: nil)
    }
}
