//
//  UserDTO.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/04.
//

import Foundation

struct UserDTO: Codable {
    let name: String
    let email: String
    let userId: String
    let token: String
}
