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
    static let scheme = "https"
    static let host = "28620c3c-a2bb-4264-bf32-8546221c8a8d.mock.pstmn.io"
    static let path = "/baseball/games"
    
    static func url(path: String) -> URL? {
        var components = URLComponents()
        
        components.scheme = EndPoint.scheme
        components.host = EndPoint.host
        components.path = "\(EndPoint.path)\(path)"
        
        return components.url
    }
}


class NetworkManager {
    
    static func get<T: Decodable>(type: T.Type, url: URL) -> AnyPublisher<T, Error> {
        
        return URLSession.shared.dataTaskPublisher(for: url)
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
    
    static func post<T: Codable>(url: URL, data: T) -> AnyPublisher<Void, Error> {

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
                return URLSession.shared.dataTaskPublisher(for: request)
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
