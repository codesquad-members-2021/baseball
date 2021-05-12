//
//  GameUseCase.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/05.
//

import Foundation
import Combine

class GameUseCase {
    let apiRequestManager = APIRequestManager()
    
    func start(url: URL) -> AnyPublisher<GameResponse, Error> {
        return apiRequestManager.fetch(url: url, method: .get)
    }
}
