//
//  PlayUseCase.swift
//  baseball
//
//  Created by zombietux on 2021/05/09.
//

import Foundation
import RxSwift

class PlayUseCase: UseCasePort {
    private var networkService: NetworkServiceable
    
    init(networkService: NetworkServiceable = NetworkService()) {
        self.networkService = networkService
    }
    
    func get<T>(path: APIPath, id: String?) -> Observable<T> where T : Decodable, T : Encodable {
        return networkService.get(path: .progress, id: id)
    }
}
