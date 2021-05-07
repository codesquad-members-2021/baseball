
import Foundation

struct Player: Decodable {
    private let name: String
    private var atBat: Int
    private var hits: Int
    private var out: Int
    private var average: Float
    
    init(name: String) {
        self.name = name
        self.atBat = 0
        self.hits = 0
        self.out = 0
        self.average = 0
    }
}
