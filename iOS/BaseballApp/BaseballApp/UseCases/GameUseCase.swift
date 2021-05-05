//
//  GameUseCase.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/05.
//

import Foundation

class GameUseCase {
    let apiRequestManager = APIRequestManager()
    let endpoint: Endpoint = Endpoint()
    
    func start(url: URL) {
        apiRequestManager.fetchGame(url: url, method: .get)
    }
}
