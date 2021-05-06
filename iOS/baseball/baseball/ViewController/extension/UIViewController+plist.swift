//
//  UIViewController+plist.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import UIKit

extension UIViewController {
    func getClientID() -> String {
        guard let path = Bundle.main.path(forResource: "OAuthKeys", ofType: "plist") else { return "" }
        let plist = NSDictionary(contentsOfFile: path)
        guard let key = plist?.object(forKey: "ClientID") as? String else { return "" }
        return key
    }
}
