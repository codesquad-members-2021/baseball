
import Foundation

struct InningInfo {
    private var currentInning: Int
    private var attackTeam: String
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
