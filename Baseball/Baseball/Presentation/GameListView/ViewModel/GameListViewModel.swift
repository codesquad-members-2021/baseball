//
//  GameListViewModel.swift
//  Baseball
//
//  Created by 지북 on 2021/05/04.
//

import Foundation
import Combine

class GameListViewModel {
    @Published private (set) var matchUpGames: [MatchUp]
    @Published private (set) var error: String
    
    private var fetchGameListUseCase: FetchGameListUseCase
    
    init(fetchGameListUseCase: FetchGameListUseCase) {
        self.matchUpGames = []
        self.error = ""
        self.fetchGameListUseCase = fetchGameListUseCase
        
        fetchGameList()
    }
    
    func fetchGameList() {
        fetchGameListUseCase.execute { result in
            switch result {
            case .success(let matchUpGames):
                self.matchUpGames = matchUpGames
            case .failure(let error):
                self.errorHandler(error: error)
            }
        }
    }
    
    private func errorHandler(error: Error) {
        self.error = error.localizedDescription
    }
}
