//
//  PlayViewModel.swift
//  ProBaseball
//
//  Created by 오킹 on 2021/05/11.
//

import Foundation
import Combine

class PlayViewModel {
    private let playUseCase: PlayUseCase
    private var subscriptions = Set<AnyCancellable>()
    @Published var game: Game?
    
    init(playUseCase: PlayUseCase) {
        self.playUseCase = playUseCase
    }
    
    func fetchGame() {
        playUseCase.fetchGame(endpoint: Endpoint.game).sink { (completion) in
            switch completion {
            case .failure(let error):
                print(error)
            case .finished:
                break
            }
        } receiveValue: { (game) in
            self.game = game
        }.store(in: &subscriptions)
    }
    
    func didUpdateGame(completion: @escaping ((Game) ->())) {
        $game
            .receive(on: DispatchQueue.main)
            .sink { (game) in
                if game != nil {
                    completion(game!)
                } else {
                    print("gameList is empty")
                    return
                }
        }.store(in: &subscriptions)
    }
}
