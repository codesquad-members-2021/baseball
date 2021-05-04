//
//  ViewController.swift
//  baseball
//
//  Created by 양준혁 on 2021/05/03.
//

import UIKit
import OctoKit
import AuthenticationServices

enum NetworkingError: String, Error {
    case responseError = "URLSession 요청이 받아들여지지 않았습니다."
    case decodeError = "JSON decode가 잘못됐습니다."
    case encodeError = "JSON encode가 잘못됐습니다."
}

class OAuthViewController: UIViewController, ASWebAuthenticationPresentationContextProviding {
    enum OauthKeys: String, CustomStringConvertible {
        case ClientID
        case ClientSecret
        
        var description: String {
            return "\(self.rawValue)"
        }
    }
    
    var tokenConfig : TokenConfiguration? = nil
    lazy var config = OAuthConfiguration.init(token: self.getOauthKey(of: .ClientID),
                                              secret: "",
                                              scopes: ["user"])
    var webAuthSession: ASWebAuthenticationSession?

    override func viewDidLoad() {
        self.configOAuth()
    }
    
    func configOAuth() {
        let callbackUrlScheme = "baseball"
        let url = config.authenticate()?.appending([URLQueryItem(name: "redirect_uri", value: "baseball://")])
        webAuthSession = ASWebAuthenticationSession.init(url: url!, callbackURLScheme: callbackUrlScheme, completionHandler: { (callBack:URL?, error:Error?) in
            
            guard error == nil, let successURL = callBack else {
                return
            }
            
            guard let callBackURLCode = successURL.absoluteString.split(separator: "=").last else { return }
            guard let url = URL(string: "http://3.36.217.168:8080/login?code=\(callBackURLCode)") else { return }
            
            self.postCode(url: url) { (result) in
                switch result {
                case .success(let userDTO):
                    DispatchQueue.main.async {
                        guard let vc = self.storyboard?.instantiateViewController(identifier: MainViewController.identifier) as? MainViewController else { return }
                        vc.user = userDTO
                        self.navigationController?.pushViewController(vc, animated: true)
                    }
                case .failure(let error):
                    print(error.localizedDescription)
                }
            }
        })
        webAuthSession?.presentationContextProvider = self
    }
    
    func postCode(url: URL, complete: @escaping (Result<UserDTO, Error>) -> Void) {
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = "POST"

        URLSession.init(configuration: .default).dataTask(with: urlRequest) { (data, response, error) in
            guard let data = data else { print("HoHo"); return }
            if error != nil {
                complete(.failure(NetworkingError.responseError))
                return
            }
            
            let decodeResult = self.decodeData(typeOf: UserDTO.self, data: data)
            
            complete(decodeResult)
        }.resume()
    }
    
    func decodeData<T: Decodable>(typeOf type: T.Type, data: Data) -> Result<T, Error> {
        do {
            let decodedData = try JSONDecoder().decode(type, from: data)
            return .success(decodedData)
        } catch {
            return .failure(NetworkingError.decodeError)
        }
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

