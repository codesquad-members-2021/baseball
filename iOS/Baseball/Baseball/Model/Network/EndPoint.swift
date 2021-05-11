//
//  EndPoint.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import Foundation

protocol Requestable {
    var baseURL: String { get }
    var path: String { get }
    var httpMethod: HttpMethod { get }
    func url() -> URL?
}

public struct GameAPIEndpoint: Requestable {
    
    public let baseURL = ""
    public let path: String
    public let httpMethod: HttpMethod
    
    init(path: String, httpMethod: HttpMethod) {
        self.path = path
        self.httpMethod = httpMethod
    }
    
    public func url() -> URL? {
        return URL(string: baseURL + path)
    }
}
