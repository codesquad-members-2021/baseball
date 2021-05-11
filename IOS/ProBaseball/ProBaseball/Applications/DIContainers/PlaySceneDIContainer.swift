//
//  PlayScene.swift
//  ProBaseball
//
//  Created by 오킹 on 2021/05/11.
//

import Foundation

final class PlaySceneDIContainer {
    func makePlayUseCase() -> PlayUseCase {
        return PlayUseCase(networkController: NetworkController())
    }

    func makePlayViewModel() -> PlayViewModel {
        return PlayViewModel(playUseCase: makePlayUseCase())
    }
}
