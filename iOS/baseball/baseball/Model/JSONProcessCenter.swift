//
//  JSONCoder.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import Foundation

protocol JSONDecodable {
    func decodeData<T: Decodable>(typeOf type: T.Type, data: Data) -> Result<T, Error>
}

final class JSONProcessCenter: JSONDecodable {
    func decodeData<T: Decodable>(typeOf type: T.Type, data: Data) -> Result<T, Error> {
        do {
            let decodedData = try JSONDecoder().decode(type, from: data)
            return .success(decodedData)
        } catch {
            return .failure(NetworkingError.decodeError)
        }
    }
}
