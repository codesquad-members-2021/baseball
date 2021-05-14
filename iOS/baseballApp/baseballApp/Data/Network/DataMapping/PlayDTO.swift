import Foundation

struct PlayDTO: Codable {
    let inningID: Int
    let inning: Int
    let attackTeamID: Int
    let ballCount: [String]
    let outCount: Int
    let pitcher: Player
    let batter: Player
    let baseStatus: [Int]
    let homeTeamScore: Int
    let awayTeamScore: Int
    
    enum CodingKeys: String, CodingKey {
        case inningID = "inning_id"
        case inning = "inning"
        case attackTeamID = "attack_team_id"
        case ballCount = "ball_count"
        case outCount = "out_count"
        case pitcher = "pitcher"
        case batter = "batter"
        case baseStatus = "base_status"
        case homeTeamScore = "home_team_score"
        case awayTeamScore = "away_team_score"
    }
}


