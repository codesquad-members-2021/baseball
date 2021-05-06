//
//  NetworkManager.swift
//  baseball
//
//  Created by 박정하 on 2021/05/05.
//

import Foundation

struct NetworkManager {
    
    enum requestScene: String {
        case gameList = ""
        
        var value: String {
            return rawValue
        }
    }
    
    enum NetworkError: Error {
        case nilResponse
        case badResponse
    }
    
    enum httpMethod: String {
        case get = "GET"
        case post = "POST"
        
        var value: String {
            return rawValue
        }
    }

    func requestbaseballGame(url: URL?, httpMethod: NetworkManager.httpMethod, completion : @escaping (Result<Int, NetworkError>) -> Void) -> Void{
        guard let makedURL: URL = url else { return }
        var request: URLRequest = URLRequest.init(url: makedURL)
        
        request.httpMethod = httpMethod.value
        
        URLSession.shared.dataTask(with: request) { data, response, error in
            let responseResult = self.checkResponse(response: response)
            completion(responseResult)
        }.resume()
    }
    
    private func checkResponse(response: URLResponse?) -> Result<Int,NetworkError> {
        guard let isresponse = response as? HTTPURLResponse else {
            return .failure(NetworkError.nilResponse)
        }
        
        if isresponse.statusCode != 200 {
            return .failure(NetworkError.badResponse)
        }
        
        return .success(200)
    }
}
