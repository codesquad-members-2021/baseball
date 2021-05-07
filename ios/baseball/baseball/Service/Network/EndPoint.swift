//
//  EndPoint.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/04.
//

import Foundation
import Alamofire

enum APIPath: String {
    case match = "api/match"
    case progress = "api/progress"
    case gameInfo = "api/gameInfo"
}

struct EndPoint: URLRequestConvertible {
    
    let method: HTTPMethod
    let path : APIPath
    let id : String?
    
    init(method: HTTPMethod, path: APIPath, id: String? = nil) {
        self.method = method
        self.path = path
        self.id = id
    }
    
    var url : URL? {
        var component = URLComponents()
        component.scheme = "http"
        component.host = "baseball.pyro-squad.com"
//        component.port = 3030
        component.path = "/\(path.rawValue)" + (id != nil ? "/\(id!)" : "")
        let url = component.url
        return url
    }
    
    func asURLRequest() throws -> URLRequest {
        var request = URLRequest.init(url: URL.init(string: "http://baseball.pyro-squad.com/api/match")!)
        do {
            request = try URLRequest.init(url: self.url!, method: self.method, headers: HTTPHeaders.init(arrayLiteral: HTTPHeader.accept("application/json")))
            
        } catch  {
            assertionFailure("EndPoint.asURLRequest")
        }
        return request
    }
    
}
