//
//  SceneDelegate.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/03.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {
    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        guard let screen = (scene as? UIWindowScene) else { return }
//        let diContainer = GameListSceneDIContainer()
    
//        let storyboard = UIStoryboard.init(name: "Main", bundle: nil)
//        let initialViewController = storyboard.instantiateViewController(identifier: "GameListViewController") as! GameListViewController
//
//        initialViewController.depend(viewModel: diContainer.makeGameListViewModel())
//
//        window = UIWindow(frame: screen.coordinateSpace.bounds)
//        window?.windowScene = screen
//        window?.rootViewController = initialViewController
//        window?.makeKeyAndVisible()
        
        let diContainer = ScoreViewSceneDIContainer()
        
        let storyboard = UIStoryboard.init(name: "Main", bundle: nil)
        let initialViewController = storyboard.instantiateViewController(identifier: "ScoreViewController") as! ScoreViewController

        initialViewController.depend(viewModel: diContainer.makeScoreViewModel())

        window = UIWindow(frame: screen.coordinateSpace.bounds)
        window?.windowScene = screen
        window?.rootViewController = initialViewController
        window?.makeKeyAndVisible()
    }
}
