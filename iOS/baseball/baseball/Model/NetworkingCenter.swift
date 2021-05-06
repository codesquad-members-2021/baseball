//
//  NetworkingCenter.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import Foundation

protocol ServerCommunicable {
    func post(url: URL, complete: @escaping (Result<Data, NetworkingError>) -> ())
}

class NetworkingCenter: ServerCommunicable {
    func post(url: URL, complete: @escaping (Result<Data, NetworkingError>) -> ()) {
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = "POST"

        URLSession.init(configuration: .default).dataTask(with: urlRequest) { (data, response, error) in
            guard let data = data else { return }
            if error != nil {
                complete(.failure(NetworkingError.responseError))
                return
            }
            complete(.success(data))
        }.resume()
    }
}
