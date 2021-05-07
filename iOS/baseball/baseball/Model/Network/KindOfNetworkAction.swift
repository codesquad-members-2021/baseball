//
//  KindOfNetworkAction.swift
//  baseball
//
//  Created by Issac on 2021/05/07.
//

import Foundation

enum KindOfNetworkAction: String {
    case login
    case logout
    case memberList
    case gameList = "games"
    case gameStart
    case gameScore = "games/scores"
    case playerScore
    
    enum HTTPMethod: String {
        case GET
        case POST
        case PATCH
    }
    
    var HTTPMethod: HTTPMethod {
        switch self {
        case .login: return .POST
        case .gameStart: return .PATCH
        default: return .GET
        }
    }
}
