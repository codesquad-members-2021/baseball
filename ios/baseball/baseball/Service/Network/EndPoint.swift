//
//  EndPoint.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/04.
//

import Foundation

struct EndPoint {
    
    enum APIPath: String {
        case test = "test"
    }
    
    private let path : APIPath
    
    init(path: APIPath) {
        self.path = path
    }
    
    var url : URL? {
        var component = URLComponents()
        component.scheme = "http"
        component.host = "localhost"
        component.port = 3030
        component.path = "\(path.rawValue)"
        
        return component.url
    }
}
