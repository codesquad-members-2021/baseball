
import Foundation

struct Game {
    private var home: Team
    private var away: Team
    private var inningInfo: InningInfo
    private var inningScores: InningScore
    private var baseState: [Bool] //갔다와서 타입으로 빼보자
}
