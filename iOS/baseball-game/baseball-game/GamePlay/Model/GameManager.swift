//
//  Game.swift
//  baseball-game
//
//  Created by Song on 2021/05/04.
//

import Foundation

class GameManager: Decodable {
    
    private var isUserHomeSide: Bool?
    private var teams: Teams
    private var inning: Inning
    private var score: Score
    private var pitchList: [Pitch]
    private var ballCounter: BallCounter
    private var baseManager: BaseManager
    private var batter: Player
    private var pitcher: Player
    
    init(isUserHomeSide: Bool, teams: Teams, inning: Inning, score: Score, pitchList: [Pitch], ballCounter: BallCounter, baseManager: BaseManager, batter: Player, pitcher: Player) {
        self.isUserHomeSide = isUserHomeSide
        self.teams = teams
        self.inning = inning
        self.score = score
        self.pitchList = pitchList
        self.ballCounter = ballCounter
        self.baseManager = baseManager
        self.batter = batter
        self.pitcher = pitcher
    }
    
    convenience init(isUserHomeSide: Bool, teams: Teams, batter: Player, pitcher: Player) {
        self.init(isUserHomeSide: isUserHomeSide,
                  teams: teams,
                  inning: Inning(),
                  score: Score(),
                  pitchList: [],
                  ballCounter: BallCounter(),
                  baseManager: BaseManager(),
                  batter: batter,
                  pitcher: pitcher)
    }
    
    enum CodingKeys: String, CodingKey {
        case isUserHomeSide
        case teams
        case inning
        case score
        case pitchList
        case ballCounter
        case baseManager
        case batter
        case pitcher
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

extension GameManager: GameManagable {

    func teamInfo() -> [String: String] {
        let home = Side.home, away = Side.away
        let homeName = teams.find(status: home)
        let awayName = teams.find(status: away)
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
        guard let isUserHomeSide = isUserHomeSide else { return nil }

        if isUserHomeSide {
            return isHomeDefense()
        } else {
            return !isHomeDefense()
        }
    }
}
