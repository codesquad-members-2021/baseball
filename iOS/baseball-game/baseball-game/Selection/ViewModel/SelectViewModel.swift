//
//  SelectViewModel.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation
import Combine

class SelectViewModel {
    
    struct GameSelectInfo {
        var gameID: String!
        var away: String!
        var home: String!
        var isAwayEnable: Bool!
        var isHomeEnable: Bool!
    }
    
    private(set) var gameInfo: GameInfo
    private(set) var gameSelectInfo: GameSelectInfo!
    
    @Published var games: [Game]!
    @Published var error: Error!
    
    private var networkManager: NetworkManageable
    private var cancelBag = Set<AnyCancellable>()
    
    weak var delegate: SelectViewModelDelegate!
    
    init(networkManager: NetworkManageable = NetworkManager()) {
        self.gameInfo = GameInfo()
        self.networkManager = networkManager
    }
}


// MARK: passing information between ViewController

extension SelectViewModel {
    
    func setUserID(with userID: String) {
        self.gameInfo.userID = userID
    }

    func setCellInfo(with game: Game) {
        self.gameInfo.gameID = game.id
        
        let gameID = "GAME \(game.id)"
        let away = game.away.team
        let home = game.home.team
        let isAwayEnable = game.away.status == "unselected"
        let isHomeEnable = game.home.status == "unselected"
        
        self.gameSelectInfo = GameSelectInfo(gameID: gameID, away: away, home: home, isAwayEnable: isAwayEnable, isHomeEnable: isHomeEnable)
    }
    
    func selected(team: String) {
        self.gameInfo.team = team
        
        self.postSelection(with: self.gameInfo)
        self.delegate.didPressButton(with: self.gameInfo)
    }

}


extension SelectViewModel {
    
    func requestGameSelection() {
        networkManager.get(type: DataDTO<[Game]>.self, url: EndPoint.url(path: "")!)
            .receive(on: DispatchQueue.main)
            .sink { error in
                self.error = error as? Error
            } receiveValue: { value in
                if let games = value.data {
                    self.games = games
                }
            }.store(in: &cancelBag)
    }

    private func postSelection(with gameInfo: GameInfo) {
        networkManager.post(url: EndPoint.url(path: "")!, data: gameInfo)
            .receive(on: DispatchQueue.main)
            .sink { error in
                print(error) ///사용자에게 에러 표시하는 부분 미구현
            } receiveValue: { _ in
                print("success") ///서버 POST 기능 미구현
            }
            .store(in: &cancelBag)
    }
    
}
