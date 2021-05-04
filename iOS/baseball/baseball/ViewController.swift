//
//  ViewController.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/03.
//

import UIKit
import OctoKit
import AuthenticationServices

class ViewController: UIViewController, ASWebAuthenticationPresentationContextProviding {
    enum OauthKeys: String, CustomStringConvertible {
        case ClientID
        case ClientSecret
        
        var description: String {
            return "\(self.rawValue)"
        }
    }
    
    var tokenConfig : TokenConfiguration? = nil
    lazy var config = OAuthConfiguration.init(token: self.getOauthKey(of: .ClientID),
                                              secret: self.getOauthKey(of: .ClientSecret),
                                              scopes: ["repo", "read:org"])
    var webAuthSession: ASWebAuthenticationSession?

    override func viewDidLoad() {
        let callbackUrlScheme = "baseball"
        let url = config.authenticate()?.appending([URLQueryItem(name: "redirect_uri", value: "baseball://")])
        webAuthSession = ASWebAuthenticationSession.init(url: url!, callbackURLScheme: callbackUrlScheme, completionHandler: { (callBack:URL?, error:Error?) in
            
            // handle auth response
            guard error == nil, let successURL = callBack else {
                return
            }

            self.config.handleOpenURL(url: successURL) { config in
                //MARK: - server로 token 전송
            }
        })
        
        webAuthSession?.presentationContextProvider = self
        webAuthSession?.start()
    }

    func presentationAnchor(for session: ASWebAuthenticationSession) -> ASPresentationAnchor {
        return self.view.window ?? ASPresentationAnchor()
    }
    
    func getOauthKey(of kind: OauthKeys) -> String {
        guard let path = Bundle.main.path(forResource: "OAuthKeys", ofType: "plist") else { return "" }
        let plist = NSDictionary(contentsOfFile: path)
        guard let key = plist?.object(forKey: kind.description) as? String else { return "" }
        return key
    }
    
    @IBAction func touchGithubLogin(_ sender: UIButton) {
        //MARK: - 눌렀을 때 OAuth 되도록
    }
}

