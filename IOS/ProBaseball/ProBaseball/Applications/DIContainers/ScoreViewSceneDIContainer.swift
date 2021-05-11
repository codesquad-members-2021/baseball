//
//  ScoreViewSceneDIContainer.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/11.
//

import Foundation

final class ScoreViewSceneDIContainer {
    func makeScoreUseCase() -> ScoreUseCaseProtocol {
        return ScoreUseCase(networkController: NetworkController())
    }

    func makeScoreViewModel() -> ScoreViewModel {
        return ScoreViewModel(scoreUseCase: makeScoreUseCase())
    }
}
