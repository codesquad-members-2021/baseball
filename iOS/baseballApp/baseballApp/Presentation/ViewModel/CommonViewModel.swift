//
//  GameModelType.swift
//  baseballApp
//
//  Created by 김지선 on 2021/05/06.
//

import Foundation

class CommonViewModel {
    let gameUsecase: GameUsecasePort
    
    init() {
        gameUsecase = GameUsecase()
    }
}
