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
                guard let url = URL(string: "asdf"),
                      let tokenData = config.accessToken?.data(using: .utf8) else { return }
                self.postToken(url: url, tokenData: tokenData) { result in
                    switch result {
                    case .success(let userDTO):
                        userDTO
                    case .failure(let error):
                        error
                    }
                }
                //MARK: - server로 token 전송
            }
        })
        webAuthSession?.presentationContextProvider = self
        
    }
    
    func postToken(url: URL, tokenData: Data, complete: @escaping (Result<UserDTO, Error>) -> Void) {
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = "POST"
        urlRequest.httpBody = tokenData

        URLSession.init(configuration: .default).dataTask(with: urlRequest) { (data, response, error) in
            guard let data = data else { return }
            if let error = error {
                complete(.failure(error))
                return
            }
            do {
                let decodingData = try JSONDecoder().decode(UserDTO.self, from: data)
                complete(.success(decodingData))
            } catch {
                complete(.failure(error))
                print(error.localizedDescription)
            }
            
        }.resume()
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
        webAuthSession?.start()
    }
}

