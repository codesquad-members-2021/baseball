//
//  GameTabBarViewController.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import UIKit

class GameTabBarViewController: UITabBarController {
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setTabBarItems()
    }
    
    private func setTabBarItems() {
        guard let gameItem = self.tabBar.items?[0] else { return }
        gameItem.image = UIImage(named: "baseball")
        gameItem.title = "Game"
        
        guard let scoreItem = self.tabBar.items?[1] else { return }
        scoreItem.image = UIImage(systemName: "chart.bar.xaxis")
        scoreItem.title = "Scores"
    }
}
