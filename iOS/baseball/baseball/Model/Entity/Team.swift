
import Foundation

struct Team {
    private let name: String
    private var score: Int
    private var players: Players
    private var pitcher: Pitcher
    
    init(name: String) {
        self.name = name
        self.score = 0
        self.players = Players()
        self.pitcher = Pitcher()
    }
}
