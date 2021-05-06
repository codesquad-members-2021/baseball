//
//  UIViewController+plist.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import UIKit

extension UIViewController {
    enum OauthKeys: String, CustomStringConvertible {
        case ClientID
        case ClientSecret
        
        var description: String {
            return "\(self.rawValue)"
        }
    }
    
    func getOauthKey(of kind: OauthKeys) -> String {
        guard let path = Bundle.main.path(forResource: "OAuthKeys", ofType: "plist") else { return "" }
        let plist = NSDictionary(contentsOfFile: path)
        guard let key = plist?.object(forKey: kind.description) as? String else { return "" }
        return key
    }
}
