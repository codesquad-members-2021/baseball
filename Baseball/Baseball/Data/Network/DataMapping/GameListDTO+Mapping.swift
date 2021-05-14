//
//  GameListDTO.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/10.
//

import Foundation

struct GameListDTO: Decodable {
    private let games: [MatchUpDTO]
    
    func toDomain() -> [MatchUp] {
        let matchUps = self.games.map { matchUpDTO in
            matchUpDTO.toDomain()
        }
        return matchUps
    }
    
    struct MatchUpDTO: Decodable {
        private let gameId: Int
        private let home: String
        private let away: String
    
        func toDomain() -> MatchUp {
            return .init(matchNumber: gameId, homeTeam: home, awayTeam: away)
        }
    }
}
