//
//  NetworkErrors.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation

enum NetworkError: Error {
    case invalidURL
    case invalidRequest
    case invalidResponse
    case invalidStatusCode(Int)
    case failParsing
}
