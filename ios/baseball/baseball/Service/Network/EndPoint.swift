//
//  EndPoint.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/04.
//

import Foundation
import Alamofire

enum APIPath: String {
    case test = "test"
}

struct EndPoint: URLRequestConvertible {
    
    let method: HTTPMethod
    let path : APIPath
    
    init(method: HTTPMethod, path: APIPath) {
        self.method = method
        self.path = path
    }
    
    var url : URL {
        var component = URLComponents()
        component.scheme = "http"
        component.host = "localhost"
        component.port = 3030
        component.path = "\(path.rawValue)"
        
        return component.url!
    }
    
    func asURLRequest() throws -> URLRequest {
        var request = URLRequest.init(url: URL.init(string: "")!)
        do {
            request = try URLRequest.init(url: self.url, method: self.method, headers: HTTPHeaders.init(arrayLiteral: HTTPHeader.accept("application/json")))
            
        } catch  {
            assertionFailure("EndPoint.asURLRequest")
        }
        return request
    }
    
    
}
