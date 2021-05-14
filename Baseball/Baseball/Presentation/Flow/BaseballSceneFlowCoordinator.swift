//
//  BaseballSceneFlowCoordinator.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit

protocol BaseballFlowCoordinatorDependencies {
    func makeGameListViewController() -> GameListViewController
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
        let vc = dependencies.makeGameListViewController()
        navigationController?.pushViewController(vc, animated: true)
        gameListVC = vc
    }
}
