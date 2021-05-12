//
//  GamePlayViewModel.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation
import Combine

class GamePlayViewModel {
    
    @Published var gameManager: GameInformable!
    @Published var pitches: [Pitch]!
    @Published var error: Error!
    
    private let userTeamSide: TeamSide
    private var networkManager: NetworkManageable
    private var cancelBag = Set<AnyCancellable>()
    
    init(_ userTeamSide: TeamSide, networkManager: NetworkManageable = NetworkManager()) {
        self.userTeamSide = userTeamSide
        self.networkManager = networkManager
    }
    
    //GameManager -> GameDTO에 따른 대대적인 변경 필요
    func requestGame() {
        networkManager.get(type: DataDTO<GameDTO>.self, url: EndPoint.url(path: "/1/start")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { value in
            if let data = value.data,
               let teams = data.teams, let batter = data.batter, let pitcher = data.pitcher {
                self.gameManager = GameManager(userTeamSide: self.userTeamSide,
                                              teams: teams,
                                              batter: batter,
                                              pitcher: pitcher)
                self.pitches = self.gameManager.pitchInfo()
                
            }
            
        }.store(in: &cancelBag)
    }
    
}
