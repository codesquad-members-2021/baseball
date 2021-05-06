//
//  SceneDelegate.swift
//  baseball-game
//
//  Created by Song on 2021/05/03.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?
    
    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        
        guard let windowScene = (scene as? UIWindowScene) else { return }
        window = UIWindow(windowScene: windowScene)

        let rootViewController = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(identifier: "LoginViewController") as LoginViewController

        let navigationViewController = UINavigationController(rootViewController: rootViewController)

        window?.rootViewController = navigationViewController
    }
}

