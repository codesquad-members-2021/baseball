//
//  NetworkingCenter.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import Foundation

protocol ServerCommunicable {
    func postLoginCode(kindOf: KindOfNetworkAction, callBackURLCode: String, complete: @escaping (Result<Data, NetworkingError>) -> ()) 
}

class NetworkingCenter: ServerCommunicable {
    func postLoginCode(kindOf kind: KindOfNetworkAction, callBackURLCode: String, complete: @escaping (Result<Data, NetworkingError>) -> ()) {
        guard let url = URL(string: "http://\(self.getHOST()):8080/login?code=\(callBackURLCode)") else { return }
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = kind.HTTPMethod.rawValue

        URLSession.init(configuration: .default).dataTask(with: urlRequest) { (data, response, error) in
            if let error = error as NSError?, error.domain == NSURLErrorDomain, error.code == NSURLErrorNotConnectedToInternet {
                complete(.failure(NetworkingError.notConnectedToInternet))
                return
            }
            
            guard let data = data, let httpResponse = response as? HTTPURLResponse else {
                complete(.failure(NetworkingError.networkError))
                return
            }
            guard 200..<300 ~= httpResponse.statusCode else {
                complete(.failure(NetworkingError.responseError))
                return
            }
            
            complete(.success(data))
        }.resume()
    }
}

extension NetworkingCenter {
    func getHOST() -> String {
        guard let path = Bundle.main.path(forResource: "NetworkElements", ofType: "plist") else { return "" }
        let plist = NSDictionary(contentsOfFile: path)
        guard let key = plist?.object(forKey: "Host") as? String else { return "" }
        return key
    }
}
