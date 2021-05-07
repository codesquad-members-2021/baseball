
import Foundation

struct Game {
    private(set) var myTeam: MyTeam
    private var home: Team
    private var away: Team
    private var inningInfo: InningInfo
    private var inningScores: InningScore
    private var baseState: BaseState
}
