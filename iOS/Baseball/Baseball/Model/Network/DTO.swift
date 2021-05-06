

import Foundation

struct GameList {
  var games: [Game]
}

struct Game {
  var home: Team
  var away: Team
  var homeScore: Int
  var awayScore: Int
  var inning: Int // 몇회
  var status: String // 초, 말
  var ballCount: [BallCount]
}

struct Team {
  var name: String
  var players: [Player]
}

struct Player {
  var name: String
  var position: String // 포지션
  var atBat: String // 타석
  var hits: Int // 안타
  var out: Int // 아웃
  var battingAverage: Double // 타율
  var numberOfPitches: Int // 투구수
}

struct BallCount {
  enum ball: Int {
    case strike = 0
    case ball = 1
    case hit = 2
  }
  var ballCount: [ball]
  var hit: Bool
}

struct Score {
  var home: [Int]
  var away: [Int]
}
