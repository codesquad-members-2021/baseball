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
            guard let data = value.data,
                  let teams = data.teams, let batter = data.batter, let pitcher = data.pitcher else { return }
            self.configureGame(with: teams, batter, pitcher)

        }.store(in: &cancelBag)
    }
    
    private func configureGame(with teams: Teams, _ batter: Player, _ pitcher: Player) {
        self.gameManager = GameManager(userTeamSide: self.userTeamSide,
                                       teams: teams,
                                       batter: batter,
                                       pitcher: pitcher)
        self.gameUpdator = self.gameManager
        self.pitchList = self.gameUpdator.pitchInfo()
    }
    
    func requestPitch() {
        networkManager.get(type: DataDTO<GameDTO>.self, url: EndPoint.url(path: "/1/pitch")!)
            .sink { error in
            self.error = error as? Error
        } receiveValue: { value in
            guard let data = value.data else { return }
            self.changeBatter(to: data.batter)
            self.changePitcher(to: data.pitcher)
            
            if let newInning = data.inning {
                self.reset(to: newInning)
            } else {
                self.updateScore(to: data.score)
                self.updatePitches(with: data.newPitch)
                self.updateBallCount(with: data.ballChanged)
                self.updateBase(with: data.baseChanged)
            }
            self.gameUpdator = self.gameManager

        }.store(in: &cancelBag)
    }
    
    private func changeBatter(to newBatter: Player?) {
        guard let newBatter = newBatter else { return }
        self.gameManager.changeBatter(to: newBatter)
    }
    
    private func changePitcher(to newPitcher: Player?) {
        guard let newPitcher = newPitcher else { return }
        self.gameManager.changePitcher(to: newPitcher)
    }
    
    private func reset(to newInning: Inning) {
        self.gameManager.resetForNewInning(with: newInning)
        self.alertMessage = AlertFactory.createMessage(alertType: .newInning)
    }
    
    private func updateScore(to newScore: Score?) {
        guard let newScore = newScore else { return }
        self.gameManager.updateScore(with: newScore)
        self.alertMessage = AlertFactory.createMessage(alertType: .newScore,
                                                       info: AlertFactory.scoreToMessage(with: newScore))
    }
    
    private func updatePitches(with newPitch: Pitch?) {
        guard let newPitch = newPitch else { return }
        self.gameManager.updatePitchList(with: newPitch)
        self.pitchList = self.gameManager.pitchInfo()
    }
    
    private func updateBallCount(with newBallInfo: BallChanged?) {
        guard let newBallInfo = newBallInfo else { return }
        self.gameManager.updateBallCount(with: newBallInfo)
    }
    
    private func updateBase(with newBaseInfo: BaseChanged?) {
        guard let newBaseInfo = newBaseInfo else { return }
        self.gameManager.updateBase(with: newBaseInfo)
    }

}
