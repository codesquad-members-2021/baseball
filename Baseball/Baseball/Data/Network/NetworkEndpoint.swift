//
//  NetworkEndpoint.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/10.
//

import Foundation

protocol Requestable {
    var baseUrl: String { get }
    var path: String { get } // games
    var httpMethod: HTTPMethod { get }
    
    func url() -> URL?
}

struct GameListEndpoint: Requestable {
    // http://ec2-3-35-10-144.ap-northeast-2.compute.amazonaws.com/games
//    var baseUrl = "http://3.35.226.74/"
    var baseUrl = "http://ec2-3-35-10-144.ap-northeast-2.compute.amazonaws.com/"
    var path = "games"
    var httpMethod: HTTPMethod
    
    init(httpMethod: HTTPMethod) {
        self.httpMethod = httpMethod
    }
    
    func url() -> URL? {
        return URL(string: baseUrl + path)
    }
}

enum HTTPMethod: String {
    case get = "GET"
    case post = "POST"
}
