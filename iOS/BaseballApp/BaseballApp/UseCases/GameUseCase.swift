//
//  GameUseCase.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/05.
//

import Foundation

class GameUseCase {
    let apiRequestManager = APIRequestManager()
    
    func start(url: URL) {
        apiRequestManager.fetchGame(url: url, method: .get)
    }
}
