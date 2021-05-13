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
        self.gameManager = GameManager(userTeamSide: self.userTeamSide, teams: Teams(home: "하하하", away: "귀찮다"), batter: Player(name: "롤로", info: "귀찮음"), pitcher: Player(name: "리아", info: "화이팅!"))
        self.gameUpdator = self.gameManager
        self.pitchList = self.gameUpdator.pitchInfo()
    }
    
    func requestPitch() {
        networkManager.get(type: DataDTO<GameDTO>.self, url: EndPoint.url(path: "/1/pitch")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { value in
            if let data = value.data {
                if let newInning = data.inning {
                    self.gameManager.resetForNewInning(with: newInning)
                }
                
                if let newScore = data.score {
                    self.gameManager.updateScore(with: newScore)
                }
                
                if let newBatter = data.batter {
                    self.gameManager.changeBatter(to: newBatter)
                }
                
                if let newPitcher = data.pitcher {
                    self.gameManager.changePitcher(to: newPitcher)
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
                self.gameUpdator = self.gameManager
            }
            
        }.store(in: &cancelBag)
        self.gameManager.updatePitchList(with: Pitch(count: 1, result: "테스트", log: "1-1"))
        self.gameManager.changeBatter(to: Player(name: "깔깔", info: "랄랄"))
        self.gameManager.updateBallCount(with: BallChanged(strike: 1, ball: 0, out: 0))
        self.gameManager.updateBase(with: BaseChanged(first: BaseChanged.BaseStatus(baseIn: true, baseOut: false), second: nil, third: nil))
        self.gameUpdator = self.gameManager
        self.pitchList = self.gameManager.pitchInfo()
    }

}
