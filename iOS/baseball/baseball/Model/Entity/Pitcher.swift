
import Foundation

struct Pitcher:Decodable {
    private var playerNumber: Int
    private var pitches: Int
    
    init() {
        self.playerNumber = 0
        self.pitches = 0
    }
}
