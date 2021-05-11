//
//  ScoreViewModel.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/11.
//

import Foundation
import Combine

class ScoreViewModel {
    private let scoreUseCase: ScoreUseCaseProtocol
    private var subscriptions = Set<AnyCancellable>()
    @Published var game: Game?
    
    init(scoreUseCase: ScoreUseCaseProtocol) {
        self.scoreUseCase = scoreUseCase
    }
    
    func fetchGameInfo() {
        scoreUseCase.fetchGameInformation(endpoint: Endpoint.game).sink { (completion) in
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
    
    func didUpdateGameInfo(completion: @escaping ((Game) ->())) {
        $game
            .sink { (game) in
                if game != nil {
                    completion(game!)
                } else {
                    print("game is empty")
                    return
                }
        }.store(in: &subscriptions)
    }
}
