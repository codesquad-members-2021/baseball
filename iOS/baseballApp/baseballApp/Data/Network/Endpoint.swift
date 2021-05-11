import Foundation

struct Endpoint {
    private let path: String
}

extension Endpoint {
    var url: URL? {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "791e125f-f50f-4801-90d3-3b106e723a88.mock.pstmn.io"
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


