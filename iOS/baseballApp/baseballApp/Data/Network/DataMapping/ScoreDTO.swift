import Foundation

struct ScoreDTO: Codable {
    let gameID: Int
    let homeTeam: TeamScore
    let awayTeam: TeamScore
    
    enum CodingKeys: String, CodingKey {
        case gameID = "game_id"
        case homeTeam = "home_team"
        case awayTeam = "away_team"
    }
}

struct TeamScore: Codable {
    let teamScore: [Int]
    let teamName: String
    let players: [PlayerInfo]
    
    enum CodingKeys: String, CodingKey {
        case teamScore = "team_score"
        case teamName = "team_name"
        case players
    }
}

struct PlayerInfo: Codable {
    let playerName: String
    let bat: Int
    let hits: Int
    let out: Int
    
    enum CodingKeys: String, CodingKey {
        case playerName = "player_name"
        case bat = "at_bat"
        case hits
        case out
    }
}
