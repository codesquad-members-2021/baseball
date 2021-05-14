//
//  NetworkService.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/10.
//

import Foundation
import Combine

protocol NetworkService {
    func request<T: Decodable>(with endpoint: Requestable, dataType: T.Type) -> AnyPublisher<T, NetworkError>
    func decode<T: Decodable>(data: Data, dataType: T.Type) -> AnyPublisher<T, NetworkError>
}

class DefaultNetworkService: NetworkService {
    func request<T>(with endpoint: Requestable, dataType: T.Type) -> AnyPublisher<T, NetworkError> where T : Decodable {
        guard let url = endpoint.url() else {
            let error = NetworkError.network(description: "couldn't create URL")
            return Fail(error: error).eraseToAnyPublisher() }
        
        var request = URLRequest(url: url)
        request.httpBody = nil
        request.httpMethod = endpoint.httpMethod.rawValue
        return URLSession.shared.dataTaskPublisher(for: request)
            .mapError{ error in
                .network(description: error.localizedDescription)
            }
            .flatMap(maxPublishers: .max(1)) { pair in
                self.decode(data: pair.data, dataType: T.self)
            }
            .eraseToAnyPublisher()
    }

    func decode<T: Decodable>(data: Data, dataType: T.Type) -> AnyPublisher<T, NetworkError> {
        let decoder = JSONDecoder()
        decoder.keyDecodingStrategy = .convertFromSnakeCase
        
        return Just(data).decode(type: T.self, decoder: decoder)
            .mapError{ error in
                .network(description: "Decode Error")
            }
            .eraseToAnyPublisher()
        
    }
}

enum NetworkError: Error {
    case network(description: String)
    case parsing(description: String)
}
