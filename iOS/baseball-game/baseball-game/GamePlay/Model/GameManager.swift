//
//  Game.swift
//  baseball-game
//
//  Created by Song on 2021/05/04.
//

import Foundation

class GameManager {
    
    private var userTeamSide: TeamSide?
    private var teams: Teams
    private var inning: Inning
    private var score: Score
    private var pitchList: [Pitch]
    private var ballCounter: BallCounter
    private var baseManager: BaseManager
    private var batter: Player
    private var pitcher: Player
    
    init(userTeamSide: TeamSide, teams: Teams, inning: Inning, score: Score, pitchList: [Pitch], ballCounter: BallCounter, baseManager: BaseManager, batter: Player, pitcher: Player) {
        self.userTeamSide = userTeamSide
        self.teams = teams
        self.inning = inning
        self.score = score
        self.pitchList = pitchList
        self.ballCounter = ballCounter
        self.baseManager = baseManager
        self.batter = batter
        self.pitcher = pitcher
    }
    
    convenience init(userTeamSide: TeamSide, teams: Teams, batter: Player, pitcher: Player) {
        self.init(userTeamSide: userTeamSide,
                  teams: teams,
                  inning: Inning(),
                  score: Score(),
                  pitchList: [],
                  ballCounter: BallCounter(),
                  baseManager: BaseManager(),
                  batter: batter,
                  pitcher: pitcher)
    }

    enum Side {
        static let home = "home"
        static let away = "away"
    }
    
    enum Role {
        static let offense = "offense"
        static let defense = "defense"
    }
    
}

///View Controller 이하의 레벨에서 게임 정보 표시하기 위해 사용
extension GameManager: GameInformable {

    func teamInfo() -> [String: String] {
        let home = Side.home, away = Side.away
        let homeName = teams.home
        let awayName = teams.away
        return [home: homeName, away: awayName]
    }

    func scoreInfo() -> [String: Int] {
        let homeScore = score.home
        let awayScore = score.away
        return [Side.home: homeScore, Side.away: awayScore]
    }

    func inningInfo() -> String {
        return inning.description
    }
    
    func pitcherInfo() -> Player {
        return pitcher
    }
    
    func batterInfo() -> Player {
        return batter
    }
    
    func pitchInfo() -> [Pitch] {
        return pitchList
    }

    private func isHomeDefense() -> Bool {
        return inning.isHomeDefense()
    }

    func isUserDefense() -> Bool? {

        guard let userTeamSide = userTeamSide else { return nil }
        
        if userTeamSide == TeamSide.home {
            return isHomeDefense()
        } else {
            return !isHomeDefense()
        }
    }
    
}

///ViewModel 이상의 레벨에서 서버에서 받아온 데이터를 프로퍼티에 업데이트하기 위해 사용
extension GameManager: GameUpdatable {
    
    func resetForNewInning(with newInning: Inning) {
        self.inning = newInning
        ballCounter.reset()
        baseManager.reset()
    }
    
    func updateScore(with newScore: Score) {
        self.score = newScore
    }
    
    func changePitcher(to newPitcher: Player) {
        self.pitcher = newPitcher
    }
    
    func changeBatter(to newBatter: Player) {
        if self.batter.name != newBatter.name { self.ballCounter.reset() }
        self.batter = newBatter
    }
    
    func updateBallCount(with ballChanged: BallChanged) {
        ballCounter.update(with: ballChanged)
    }
    
    func updateBase(with baseChanged: BaseChanged) {
        baseManager.update(with: baseChanged)
    }
    
    func updatePitchList(with newPitch: Pitch) {
        self.pitchList.insert(newPitch, at: 0)
    }
    
}
