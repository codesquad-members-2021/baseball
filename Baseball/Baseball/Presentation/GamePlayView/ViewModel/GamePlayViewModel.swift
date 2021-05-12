//
//  GamePlayViewModel.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/12.
//

import Foundation
import Combine

class GamePlayViewModel {
    @Published private (set) var gamePlay: GamePlay!
    @Published private (set) var error: String
    
    private var fetchGamePlayUseCase: FetchGamePlayUseCase
    private var matchId: Int
    
    init(matchId: Int, fetchGamePlayUseCase: FetchGamePlayUseCase) {
        self.matchId = matchId
        self.error = ""
        self.fetchGamePlayUseCase = fetchGamePlayUseCase
        fetchGamePlay()
    }
    
    func fetchGamePlay() {
        fetchGamePlayUseCase.execute(matchId: matchId)  { result in
            switch result {
            case .success(let gamePlay):
                self.gamePlay = gamePlay
                print(result)
            case .failure(let error):
                self.errorHandler(error: error)
            }
        }
    }
    
    private func errorHandler(error: NetworkError) {
        switch error {
        case .network(description: let des):
            self.error = des
        case .parsing(description: let des):
            self.error = des
        }
    }
}
