

import Foundation
import Combine

class Network {
    
    func request<T: Decodable>(with endPoint: Requestable, dataType: T.Type)
    -> AnyPublisher<T, NetworkError> {
        
        guard let url = endPoint.url() else {
            let error = NetworkError.network(description: "Couldn't Create URL")
            return Fail(error: error).eraseToAnyPublisher()
        }
        
        var request = URLRequest(url: url)
        request.httpBody = nil
        request.httpMethod = endPoint.httpMethod.rawValue
        
        return URLSession.shared.dataTaskPublisher(for: request)
            .mapError { error in
                .network(description: error.localizedDescription)
            }
            .flatMap(maxPublishers: .max(1)) { pair in
                self.decode(data: pair.data, dataType: T.self)
            }
            .eraseToAnyPublisher()
    }
    
    func post<T: Encodable> (with endPoint: Requestable, dataType: T)
    -> AnyPublisher<Int, NetworkError> {
        guard let url = endPoint.url() else {
            let error = NetworkError.network(description: "Couldn't Create URL")
            return Fail(error: error).eraseToAnyPublisher()
        }
        
        let result = encode(anyData: dataType)
        let json: Data
        switch result {
        case .failure(let error):
            return Fail(error: error).eraseToAnyPublisher()
        case .success(let data):
            json = data
        }
        
        var request = URLRequest(url: url)
        request.httpBody = json
        request.httpMethod = endPoint.httpMethod.rawValue
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        
        if json != nil {
            request.setValue(String(json.count),
                             forHTTPHeaderField: "Content-Length")
        }
        
        return URLSession.shared.dataTaskPublisher(for: request)
            .tryMap { data, response -> Int in
                guard let httpResponse = response as? HTTPURLResponse else {
                    throw NetworkError.network(description: "Couldn't Create URL")
                }
                return httpResponse.statusCode
            }
            .mapError { error in
                NetworkError.network(description: error.localizedDescription)
            }
            .eraseToAnyPublisher()
    }
    
    func decode<T: Decodable>(data: Data, dataType: T.Type) -> AnyPublisher<T, NetworkError> {
      let decoder = JSONDecoder()
        decoder.keyDecodingStrategy = .convertFromSnakeCase
      
      return Just(data)
        .decode(type: T.self, decoder: decoder)
        .mapError { error in
          .parsing(description: error.localizedDescription)
        }
        .eraseToAnyPublisher()
    }
    
    func encode<T:Encodable>(anyData: T) -> Result<Data,NetworkError> {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
        
        guard let data = try? encoder.encode(anyData) else {
            return Result.failure(NetworkError.encoding(description: "encoding Failure"))
        }
        return Result.success(data)
    }
}


enum NetworkError: Error {
    case encoding(description: String)
    case parsing(description: String)
    case network(description: String)
}

public enum HttpMethod: String {
    case get = "GET"
    case post = "POST"
}
