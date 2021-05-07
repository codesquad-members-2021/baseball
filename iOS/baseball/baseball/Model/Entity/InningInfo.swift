
import Foundation

struct InningInfo {
    private var currentInning: Int
    private(set) var attackTeam: String //ScoreViewController isAttack함수를 사용하기 위해서 임시 컨트롤 access
    private var batter: Int
    private var strike: Int
    private var ball: Int
    private var out: Int
    private var pitchingHistory: PitchingHistory
    
    init() {
        self.currentInning = 0
        self.attackTeam = ""
        self.batter = 0
        self.strike = 0
        self.ball = 0
        self.out = 0
        self.pitchingHistory = PitchingHistory()
    }
}
