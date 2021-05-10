//
//  MatchViewModel.swift
//  baseball
//
//  Created by zombietux on 2021/05/07.
//

import Foundation
import RxSwift

class MatchViewModel {
    private(set) var matchs = BehaviorSubject<[Match]>(value: [])
    private var matchUseCase: MatchUseCasePort!
    
    init(matchUseCase: MatchUseCasePort = MatchUseCase()) {
        self.matchUseCase = matchUseCase
        self.fetchMatchs()
    }
    
    private func fetchMatchs() {
        matchUseCase.get(path: .match, id: nil)
            .take(1)
            .bind(to: matchs)
    }
}
