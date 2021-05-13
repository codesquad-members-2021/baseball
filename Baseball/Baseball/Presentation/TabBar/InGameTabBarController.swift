//
//  InGameTabBarController.swift
//  Baseball
//
//  Created by 지북 on 2021/05/12.
//

import UIKit

class InGameTabBarController: UITabBarController {

    static let storyboardName = "Main"
    static let storyboardID = "InGameTabBarController"
    
    static func create(playVC: GamePlayViewController, scoreVC: GameScoreViewController) -> InGameTabBarController {
        let storyboard = UIStoryboard(name: storyboardName, bundle: Bundle.main)
        guard let vc = storyboard.instantiateViewController(identifier: storyboardID) as? InGameTabBarController else {
            return InGameTabBarController()
        }
    
        let playViewBarItem = UITabBarItem(title: "playView", image: UIImage(named: "baseball-player.png"), selectedImage: UIImage(named: "baseball-player.png"))
        let scoreViewBarItem = UITabBarItem(title: "scoreView", image: UIImage(named: "analytics.png"), selectedImage: UIImage(named: "analytics.png"))

        playVC.tabBarItem = playViewBarItem
        scoreVC.tabBarItem = scoreViewBarItem
        
        vc.viewControllers = [playVC, scoreVC]
        return vc
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
