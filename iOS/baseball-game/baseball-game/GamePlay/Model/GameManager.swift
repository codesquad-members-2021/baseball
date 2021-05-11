//
//  Game.swift
//  baseball-game
//
//  Created by Song on 2021/05/04.
//

import Foundation

class GameManager: Decodable {
    
    private var userTeamSide: TeamSide?
    var turn: Turn
    
    init(userTeamSide: TeamSide, turn: Turn) {
        self.userTeamSide = userTeamSide
        self.turn = turn
    }
    
    enum CodingKeys: String, CodingKey {
        case userTeamSide
        case turn = "game"
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
    
    func teams() -> [String: String] {
        let homeTeam = turn.home.name
        let awayTeam = turn.away.name
        return [Side.home: homeTeam, Side.away: awayTeam]
    }
    
    func scores() -> [String: Int] {
        let homeScore = turn.home.score
        let awayScore = turn.away.score
        return [Side.home: homeScore, Side.away: awayScore]
    }
    
    func inning() -> String {
        let inningInfos = turn.inning
        let topOrBottom = inningInfos[1] == 1 ? "초" : "말"
        return "\(inningInfos[0])회 \(topOrBottom)"
    }

    func pitcher() -> Player {
        return isHomeDefense() ? turn.home.player : turn.away.player
    }
    
    func batter() -> Player {
        return isHomeDefense() ? turn.away.player : turn.home.player
    }
    
    private func isHomeDefense() -> Bool {
        return turn.home.role == Role.defense
    }
    
    func isUserDefense() -> Bool? {
        guard let userTeamSide = userTeamSide else { return nil }
        
        if userTeamSide == TeamSide.home {
            return isHomeDefense()
        } else {
            return turn.away.role == Role.defense
        }
    }
    
}
