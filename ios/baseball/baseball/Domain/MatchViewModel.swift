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
    private(set) var id: Observable<String>?
    private var disposeBag = DisposeBag()
    
    init(matchUseCase: MatchUseCasePort = MatchUseCase()) {
        self.matchUseCase = matchUseCase
        self.fetchMatchs()
    }
    
    private func fetchMatchs() {
        matchUseCase.get(path: .match, id: nil)
            .take(1)
            .bind(to: matchs)
    }
    
    func setPlayTabId(at index: Int) {
        self.matchs.map {
            let id = $0[index].id
            let idObservable = Observable<String>.just(id)
            idObservable.subscribe { [weak self] event in
                print("event", event)
            }
            .disposed(by: self.disposeBag)
        }
    }
}
