//
//  APIRequestManager.swift
//  BaseballApp
//
//  Created by Song on 2021/05/05.
//

import Foundation
import Combine

class APIRequestManager {
    
    private func createRequest(url: URL, method: HTTPMethod, httpBody: Data? = nil) -> URLRequest {
        var request = URLRequest(url: url)
        request.httpMethod = method.rawValue
        request.httpBody = httpBody
        return request
    }
  
    func fetch<T: Decodable>(url: URL, method: HTTPMethod, httpBody: Data? = nil) -> AnyPublisher<T, Error> {
        let request = createRequest(url: url, method: method)
        return URLSession.shared.dataTaskPublisher(for: request)
            .map(\.data)
            .decode(type: T.self, decoder: JSONDecoder())
            .eraseToAnyPublisher()
    }
}

struct Endpoint {
    enum Path {
        static let gameList = "/game/list"
        static let gameStatus = "/game/status"
    }
    
    static func url(path: String) -> URL? {
        var components = URLComponents()
        components.scheme = "http"
        components.host = "52.78.19.43"
        components.port = 8080
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
