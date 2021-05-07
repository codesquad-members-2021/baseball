//
//  ViewController.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/03.
//

import UIKit
import OctoKit
import AuthenticationServices

class OAuthViewController: UIViewController, ASWebAuthenticationPresentationContextProviding {
    lazy var config = OAuthConfiguration.init(token: self.getClientID(),
                                              secret: "",
                                              scopes: ["user"])
    var webAuthSession: ASWebAuthenticationSession?
    var gameManager: GameManager!

    override func viewDidLoad() {
        self.configOAuth()
        let networkingCenter = NetworkingCenter()
        let jsonProcessCenter = JSONProcessCenter()
        self.gameManager = GameManager(serverCommunicable: networkingCenter, JSONDecodable: jsonProcessCenter)
    }
    
    func configOAuth() {
        let callbackUrlScheme = "baseball"
        guard let url = config.authenticate()?.appending([URLQueryItem(name: "redirect_uri", value: "baseball://")]) else { return }
        webAuthSession = ASWebAuthenticationSession.init(url: url, callbackURLScheme: callbackUrlScheme, completionHandler: { (callBack:URL?, error:Error?) in
            if error != nil {
                #if DEBUG
                NSLog(NetworkingError.ASWebAuthenticationSessionError.rawValue)
                #endif
                return
            }
            guard let successURL = callBack else { return }
            let callBackURLCode = successURL.extractCallbackURLCode()
            
            self.gameManager.postLoginCode(callBackURLCode: String(callBackURLCode)) { (result) in
                switch result {
                case .success(let userDTO):
                    guard let vc = self.storyboard?.instantiateViewController(identifier: MainViewController.identifier) as? MainViewController else { return }
                    vc.user = userDTO
                    self.navigationController?.pushViewController(vc, animated: true)
                case .failure(let error):
                    #if DEBUG
                    NSLog(error.localizedDescription)
                    #endif
                }
            }
        })
        webAuthSession?.presentationContextProvider = self
    }

    func presentationAnchor(for session: ASWebAuthenticationSession) -> ASPresentationAnchor {
        return self.view.window ?? ASPresentationAnchor()
    }
    
    @IBAction func touchGithubLogin(_ sender: UIButton) {
        webAuthSession?.start()
    }
}

extension OAuthViewController {
    func getClientID() -> String {
        guard let path = Bundle.main.path(forResource: "NetworkElements", ofType: "plist") else { return "" }
        let plist = NSDictionary(contentsOfFile: path)
        guard let key = plist?.object(forKey: "ClientID") as? String else { return "" }
        return key
    }
}
