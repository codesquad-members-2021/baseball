//
//  GameManager.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import Foundation

class GameManager {
    let networkingCenter: ServerCommunicable
    let jsonProcessCenter: JSONDecodable
    
    init(serverCommunicable: ServerCommunicable, JSONDecodable: JSONDecodable) {
        self.networkingCenter = serverCommunicable
        self.jsonProcessCenter = JSONDecodable
    }
    
    func postLoginCode(callBackURLCode: String, completion: @escaping (Result<UserDTO, NetworkingError>) -> ()) {
        guard let url = URL(string: "http://3.36.217.168:8080/login?code=\(callBackURLCode)") else { return }
        networkingCenter.post(url: url) { (result) in
            switch result {
            case .success(let data):
                let decodeResult = self.jsonProcessCenter.decodeData(typeOf: UserDTO.self, data: data)
                switch decodeResult {
                case .success(let userDTO):
                    DispatchQueue.main.async {
                        completion(.success(userDTO))
                    }
                case .failure(_):
                    completion(.failure(NetworkingError.decodeError))
                }
            case .failure(_):
                completion(.failure(NetworkingError.responseError))
            }
        }
    }
}
