
import Foundation

struct Players: Decodable {
    private var players: [Player]
    
    init() {
        self.players = []
    }
}
