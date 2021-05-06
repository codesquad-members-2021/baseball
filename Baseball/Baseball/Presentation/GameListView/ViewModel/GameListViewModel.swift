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
    
    init() {
        self.matchUpGames = []
    }
    
    
}
