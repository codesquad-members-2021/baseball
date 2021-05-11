//
//  NetworkManager.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation
import Combine

protocol NetworkControllerProtocol {
    typealias Headers = [String: Any]
    
    func get<T>(type: T.Type,
                url: URL?,
                method: HTTPMethod
    ) -> AnyPublisher<T, NetworkError> where T: Codable
}

final class NetworkController: NetworkControllerProtocol {
    func get<T>(type: T.Type, url: URL?, method: HTTPMethod) -> AnyPublisher<T, NetworkError> where T : Codable {
        guard let safeURL = url else {
            return Fail(error: NetworkError.invalidURL).eraseToAnyPublisher()
        }
        
        var urlRequest = URLRequest(url: safeURL)
        urlRequest.httpMethod = method.rawValue
        
        return URLSession.shared.dataTaskPublisher(for: urlRequest)
            .mapError({ _ in
                return NetworkError.invalidRequest
            })
            .flatMap { (data, response) -> AnyPublisher<T, NetworkError> in
                guard let validResponse = response as? HTTPURLResponse else {
                    return Fail(error: NetworkError.invalidResponse).eraseToAnyPublisher()
                }
                guard 200..<300 ~= validResponse.statusCode else {
                    return Fail(error:NetworkError.invalidStatusCode(validResponse.statusCode)).eraseToAnyPublisher()
                }
                
                return Just(data)
                    .decode(type: T.self, decoder: JSONDecoder())
                    .mapError { _ in
                        NetworkError.failParsing
                    }.eraseToAnyPublisher()
            }.eraseToAnyPublisher()
    }
}

