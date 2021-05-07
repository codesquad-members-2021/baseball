
import Foundation

struct URLManager {
    enum Url: String {
        case gameList = ""
    }
    
    static func get(url: Url) -> URL? {
        guard let url = URL(string: url.rawValue) else {
            print("The URL is inappropriate.")
            return nil
        }
        return url
    }
}
