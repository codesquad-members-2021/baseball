//
//  GameListViewModel.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import Foundation

class GameListViewModel {
    @Published var gameList: GameList!
    private var fetchGameList: FetchGameList
    
    init(fetchGameList: FetchGameList) {
        self.fetchGameList = FetchGameList()
        fetchGameListViewModel()
    }
    
    func fetchGameListViewModel() {
        fetchGameList.fetchGameList(completion: { result in
            self.gameList = result.gameList
        })
    }
    
}
