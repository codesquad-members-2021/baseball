//
//  ScoreViewModel.swift
//  baseball
//
//  Created by zombietux on 2021/05/10.
//

import Foundation
import RxSwift

class ScoreViewModel {
    private(set) var gameInfo = BehaviorSubject<GameInfo>(value: GameInfo())
    private var scoreUseCase: ScoreUseCasePort!
    lazy private(set) var scores = gameInfo.map {
        $0.scores
    }
    
    lazy private(set) var inningsScore = gameInfo.map {
        $0.innings
    }
    
    init(scoreUseCase: ScoreUseCasePort = ScoreUseCase(), id: String) {
        self.scoreUseCase = scoreUseCase
        self.fetchGameInfo(id: id)
    }
    
    private func fetchGameInfo(id: String) {
        scoreUseCase.get(path: .gameInfo, id: id)
            .debug()
            .bind(to: gameInfo)
    }
}
