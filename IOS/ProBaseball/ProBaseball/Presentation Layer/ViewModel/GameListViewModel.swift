//
//  GameListViewModel.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/09.
//

import Foundation
import Combine

class GameListViewModel {
    private let gameListUseCase: GameListUseCase
    private var subscriptions = Set<AnyCancellable>()
    @Published var gameList: GameList?
    
    init(gameListUseCase: GameListUseCase) {
        self.gameListUseCase = gameListUseCase
    }
    
    func fetchGameList() {
        gameListUseCase.fetchGameList(endpoint: Endpoint.test).sink { (completion) in
            switch completion {
            case .failure(let error):
                print(error)
            case .finished:
                break
            }
        } receiveValue: { (gameList) in
            self.gameList = gameList
        }.store(in: &subscriptions)
    }
    
    func didUpdateGameList(completion: @escaping ((GameList) ->())) {
        $gameList
            .sink { (gameList) in
                if gameList != nil {
                    completion(gameList!)
                } else {
                    print("gameList is empty")
                    return
                }
        }.store(in: &subscriptions)
    }
}
