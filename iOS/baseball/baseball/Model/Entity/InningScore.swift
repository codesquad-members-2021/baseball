
import Foundation

struct InningScore: Decodable {
    private var homeScore: [Int]
    private var awayScore: [Int]
    
    init() {
        self.homeScore = []
        self.awayScore = []
    }
}
