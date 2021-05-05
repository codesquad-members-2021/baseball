//
//  APIRequestManager.swift
//  BaseballApp
//
//  Created by Song on 2021/05/05.
//

import Foundation
import Combine
class APIRequestManager {
    @Published var rooms: RoomResponse = RoomResponse(rooms: [])
    var cancelBag = Set<AnyCancellable>()
    func fetch(url: URL, method: HTTPMethod, httpBody: Data? = nil) {
        var request = URLRequest(url: url)
        request.httpMethod = method.rawValue
        request.httpBody = httpBody
        URLSession.shared.dataTaskPublisher(for: request)
            .map(\.data)
            .decode(type: RoomResponse.self, decoder: JSONDecoder())
            .replaceError(with: RoomResponse(rooms: []))
            .assign(to: \.rooms, on: self)
            .store(in: &self.cancelBag)
    }
}
struct Endpoint {
    func url(path: String, method: HTTPMethod) -> URL? {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.github.com"
        components.path = path
        return components.url
    }
}
enum HTTPMethod: String {
    case get = "GET"
    case post = "POST"
    case put = "PUT"
    case delete = "DELETE"
}
