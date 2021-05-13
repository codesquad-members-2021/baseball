//
//  BaseballSceneFlowCoordinator.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit

protocol BaseballFlowCoordinatorDependencies {
    func makeGameListViewController(action: GameListViewModelAction) -> GameListViewController
    func makeGamePlayViewController(matchId: Int) -> GamePlayViewController
    func makeGameScoreViewController() -> GameScoreViewController
}

class BaseballSceneFlowCoordinator {
    private weak var navigationController: UINavigationController?
    private var gameListVC: GameListViewController?
    private var dependencies: BaseballFlowCoordinatorDependencies
    
    init(navigationController: UINavigationController, dependencies: BaseballFlowCoordinatorDependencies) {
        self.navigationController = navigationController
        self.dependencies = dependencies
    }
    
    func start() {
        let action = GameListViewModelAction(showGamePlayView: showGamePlayView(matchUp:))
        let vc = dependencies.makeGameListViewController(action: action)
        navigationController?.pushViewController(vc, animated: true)
        gameListVC = vc
    }
    
    // let showGamePlayView: ((Int)-> Void)
    func showGamePlayView(matchUp: Int) {
        let playVC = dependencies.makeGamePlayViewController(matchId: matchUp)
        let scoreVC = dependencies.makeGameScoreViewController()
        
        let tabBarVC = InGameTabBarController.create(playVC: playVC, scoreVC: scoreVC)
        self.navigationController?.present(tabBarVC, animated: true)
    }
}
