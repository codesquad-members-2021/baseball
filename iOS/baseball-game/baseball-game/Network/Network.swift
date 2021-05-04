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
    
    func request<T: Decodable>(type: T.Type, url: URL) -> AnyPublisher<T, Error> {
        
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
}
