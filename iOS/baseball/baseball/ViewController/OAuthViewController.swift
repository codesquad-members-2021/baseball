//
//  ViewController.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/03.
//

import UIKit
import OctoKit
import AuthenticationServices

final class OAuthViewController: UIViewController, ASWebAuthenticationPresentationContextProviding {
    var webAuthSession: ASWebAuthenticationSession?
    var gameManager: GameManager!
    var oauthManager: OAuthManager!

    override func viewDidLoad() {
        super.viewDidLoad()
        let networkingCenter = NetworkingCenter()
        let jsonProcessCenter = JSONProcessCenter()
        self.gameManager = GameManager(serverCommunicable: networkingCenter, JSONDecodable: jsonProcessCenter)
        self.oauthManager = OAuthManager(serverCommunicable: networkingCenter, JSONDecodable: jsonProcessCenter)
        self.configOAuth()
    }
    
    func configOAuth() {
        webAuthSession = self.oauthManager.initPostLoginCodeWebAuthSession() { (result) in
            switch result {
            case .success(let userDTO):
                guard let vc = self.storyboard?.instantiateViewController(identifier: MainViewController.className) as? MainViewController else { return }
                vc.user = userDTO
                self.navigationController?.pushViewController(vc, animated: true)
            case .failure(let error):
                #if DEBUG
                NSLog(error.rawValue)
                #endif
            }
        }
        webAuthSession?.presentationContextProvider = self
    }

    func presentationAnchor(for session: ASWebAuthenticationSession) -> ASPresentationAnchor {
        return self.view.window ?? ASPresentationAnchor()
    }
    
    @IBAction func touchGithubLogin(_ sender: UIButton) {
        webAuthSession?.start()
    }
}
