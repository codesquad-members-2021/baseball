//
//  Network.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation
import Combine

enum NetworkError: Error {
    case BadURL
    case DecodingError
}

enum EndPoint {
    static let scheme = "http"
    static let host = "ec2-3-35-235-30.ap-northeast-2.compute.amazonaws.com"
    static let port = 8080
    static let path = "/baseball/games"

    static func url(path: String) -> URL? {
        var components = URLComponents()
        
        components.scheme = EndPoint.scheme
        components.host = EndPoint.host
        components.port = EndPoint.port
        components.path = "\(EndPoint.path)\(path)"
        
        return components.url
    }
}


protocol NetworkManageable {
    func get<T: Decodable>(type: T.Type, url: URL) -> AnyPublisher<T, Error>
    func post<T: Codable>(url: URL, data: T) -> AnyPublisher<Void, Error>
}


class NetworkManager {
    
    private let session: URLSession
    
    init(session: URLSession = .shared) {
      self.session = session
    }
    
}


extension NetworkManager: NetworkManageable {
    
    func get<T: Decodable>(type: T.Type, url: URL) -> AnyPublisher<T, Error> {
        
        return self.session.dataTaskPublisher(for: url)
            .tryMap { element -> Data in
                guard let httpResponse = element.response as? HTTPURLResponse,
                    httpResponse.statusCode == 200 else {
                    throw NetworkError.BadURL
                    }
                return element.data
            }
            .decode(type: T.self, decoder: JSONDecoder())
            .mapError({ (error) -> Error in
                return error
            })
            .eraseToAnyPublisher()
    }
    
    func post<T: Codable>(url: URL, data: T) -> AnyPublisher<Void, Error> {

        return Just(data)
            .encode(encoder: JSONEncoder())
            .mapError { error -> Error in
                print(error) ///사용자에게 에러 표시하는 부분 미구현
                return error
            }
            .map { data -> URLRequest in
                var request = URLRequest(url: url)
                request.httpMethod = "post"
                request.httpBody = data
                request.addValue("application/json", forHTTPHeaderField: "Content-Type")
                request.setValue(String(data.count), forHTTPHeaderField: "Content-Length")
                
                return request
            }
            .flatMap { request in
                return self.session.dataTaskPublisher(for: request)
                    .tryMap { element -> Void in
                        guard let httpResponse = element.response as? HTTPURLResponse,
                              httpResponse.statusCode == 200 else {
                            throw NetworkError.BadURL
                        }
                        return
                    }
            }
            .eraseToAnyPublisher()
    }
    
}
