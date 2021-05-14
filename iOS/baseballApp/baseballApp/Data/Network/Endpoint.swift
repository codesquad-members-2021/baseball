import Foundation

struct Endpoint {
    private let path: String
}

extension Endpoint {
    var url: URL? {
        var components = URLComponents()
        components.scheme = "https"
//        https://f0eb7133-38c6-4f20-96a2-4a438fe100c8.mock.pstmn.io/baseball
        components.host = "f0eb7133-38c6-4f20-96a2-4a438fe100c8.mock.pstmn.io"
//        components.port = 8080
        components.path = self.path
        return components.url
    }

    func test() -> URL? {
        return url
    }
    
    static func getGames(path: String) -> URL? {
        return Endpoint(path: "/\(path)").url
    }
}


