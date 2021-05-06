//
//  NetworkingCenter.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import Foundation

enum Path: String {
    case login
    case logout
    case memberList
    case gameList = "games"
    case gameStart
    case gameScore = "games/scores"
    case playerScore
}

enum Endpoint {
    private static let scheme = "http"
    private static let host = "3.36.217.168:8080"
    static func url(path : Path, parameter: String = "") -> URL? {
        var components = URLComponents()
        components.scheme = Endpoint.scheme
        components.host = Endpoint.host
        components.path = {
            switch path {
            case .login: return "login?code=\(parameter)"
            case .memberList: return "members/\(parameter)"
            case .gameStart: return "games/\(parameter)"
            case .playerScore: return "games/scores/\(parameter)"
            default: return path.rawValue
            }
        }()
        return components.url
    }
}

enum HttpMethod: String {
    case GET
    case POST
    case PATCH
}

protocol ServerCommunicable {
    func postLoginCode(callBackURLCode: String, complete: @escaping (Result<Data, NetworkingError>) -> ())
}

class NetworkingCenter: ServerCommunicable {
    func postLoginCode(callBackURLCode: String, complete: @escaping (Result<Data, NetworkingError>) -> ()) {
        guard let url = Endpoint.url(path: .login, parameter: callBackURLCode) else { return }
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = HttpMethod.POST.rawValue

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
