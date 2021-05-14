//
//  GamePlayViewModel.swift
//  baseball-game
//
//  Created by Song on 2021/05/06.
//

import Foundation
import Combine

class GamePlayViewModel {
    
    private var gameManager: GameUpdatable!
    @Published var gameUpdator: GameInformable!
    @Published var pitchList: [Pitch]!
    @Published var error: Error!
    @Published var alertMessage: String!
    
    private let userTeamSide: TeamSide
    private var networkManager: NetworkManageable
    private var cancelBag = Set<AnyCancellable>()
    
    init(_ userTeamSide: TeamSide, networkManager: NetworkManageable = NetworkManager()) {
        self.userTeamSide = userTeamSide
        self.networkManager = networkManager
    }
    
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
                self.gameUpdator = self.gameManager
                self.pitchList = self.gameUpdator.pitchInfo()
            }

        }.store(in: &cancelBag)
    }
    
    func requestPitch() {
        networkManager.get(type: DataDTO<GameDTO>.self, url: EndPoint.url(path: "/1/pitch")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { value in
            if let data = value.data {
                if let newBatter = data.batter {
                    self.gameManager.changeBatter(to: newBatter)
                }

                if let newPitcher = data.pitcher {
                    self.gameManager.changePitcher(to: newPitcher)
                }
                
                if let newInning = data.inning {
                    self.gameManager.resetForNewInning(with: newInning)
                    self.alertMessage = AlertFactory.createMessage(alertType: .newInning)
                } else {
                    if let newScore = data.score {
                        self.gameManager.updateScore(with: newScore)
                        self.alertMessage = AlertFactory.createMessage(alertType: .newScore,
                                                                       info: AlertFactory.scoreToMessage(with: newScore))
                    }
                    
                    if let newPitch = data.newPitch {
                        self.gameManager.updatePitchList(with: newPitch)
                        self.pitchList = self.gameManager.pitchInfo()
                    }

                    if let newBallInfo = data.ballChanged {
                        self.gameManager.updateBallCount(with: newBallInfo)
                    }

                    if let newBaseInfo = data.baseChanged {
                        self.gameManager.updateBase(with: newBaseInfo)
                    }
                }
                self.gameUpdator = self.gameManager
            }

        }.store(in: &cancelBag)
    }

}
