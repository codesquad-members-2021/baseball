import Foundation

struct Game: Codable {
    let id: Int
    let homeID: Int
    let home: String
    let homeScore: Int
    let awayID: Int
    let away: String
    let awayScore: Int
    let inningID: Int
    
    enum CodingKeys: String, CodingKey {
        case id = "game_id"
        case homeID = "home_team_id"
        case home = "home_team"
        case homeScore = "home_team_score"
        case awayID = "away_team_id"
        case away = "away_team"
        case awayScore = "away_team_score"
        case inningID = "now_inning_id"
    }
}
