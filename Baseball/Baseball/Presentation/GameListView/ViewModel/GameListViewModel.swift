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
    private var fetchGameListUseCase: FetchGameListUseCase
    
    init(fetchGameListUseCase: FetchGameListUseCase) {
        self.matchUpGames = []
        self.fetchGameListUseCase = fetchGameListUseCase
        
        fetchGameList()
    }
    
    private func fetchGameList() {
        fetchGameListUseCase.execute { matchUps in
            self.matchUpGames = matchUps
        }
    }
}
