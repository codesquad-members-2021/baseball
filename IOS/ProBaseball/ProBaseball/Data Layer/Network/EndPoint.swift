//
//  EndPoint.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/08.
//

import Foundation

class Endpoint {
    private var path: String
    private var queryItems: [URLQueryItem] = []
    
    init(path: String) {
        self.path = path
    }
}

extension Endpoint {
    var url: URL? {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "87d10a6c-c551-4948-98bf-9b748675f31d.mock.pstmn.io"
        components.path = self.path
        components.queryItems = queryItems
        
        return components.url
    }
    
    var headers: [String: Any] {
           return ["app-id": "com.jjstudio.ProBaseball"]
    }
}

extension Endpoint {
    static var test: Self {
        return Endpoint(path: "/test") as! Self
    }
    
    static var game: Self {
        return Endpoint(path: "/game") as! Self
    }
    
//    static func users(count: Int) -> Self {
//           return Endpoint(path: "/user",
//                           queryItems: [
//                               URLQueryItem(name: "limit",
//                                            value: "\(count)")
//               ]
//           )
//       }
//
//       static func user(id: String) -> Self {
//           return Endpoint(path: "/user/\(id)")
//       }
}

