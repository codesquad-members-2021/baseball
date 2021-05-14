//
//  GameListDTO.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/10.
//

import Foundation

struct GameListDTO: Decodable {
    private let matchUpList: [MatchUpDTO]
    
    func toDomain() -> [MatchUp] {
        let matchUps = self.matchUpList.map { matchUpDTO in
            matchUpDTO.toDomain()
        }
        return matchUps
    }
    
    struct MatchUpDTO: Decodable {
        private let matchId: Int
        private let home: String
        private let away: String
    
        func toDomain() -> MatchUp {
            return .init(matchNumber: matchId, homeTeam: home, awayTeam: away)
        }
    }
}
