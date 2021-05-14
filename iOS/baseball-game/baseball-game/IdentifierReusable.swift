//
//  IdentifierReusable.swift
//  baseball-game
//
//  Created by Lia on 2021/05/11.
//

import Foundation

protocol IdentifierReusable {
    static var reuseIdentifier: String { get }
}

extension IdentifierReusable {
    static var reuseIdentifier: String {
        return String(describing: self)
    }
}
