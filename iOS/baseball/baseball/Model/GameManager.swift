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
    
    
}
