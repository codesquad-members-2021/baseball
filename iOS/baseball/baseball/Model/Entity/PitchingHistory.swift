
import Foundation

struct PitchingHistory:Decodable {
    private var pitch: String
    private var status: String
    
    init() {
        self.pitch = ""
        self.status = ""
    }
}
