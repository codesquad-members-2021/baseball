//
//  AppFlowCoordinator.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit

class AppFlowCoordinator {
    private var navigationController: UINavigationController
    private var appDIContainer: AppDIContainer
    
    init(navigationController: UINavigationController, appDIContainer: AppDIContainer) {
        self.navigationController = navigationController
        self.appDIContainer = appDIContainer
    }
    
    func start() {
        let baseballSceneDIContainer = appDIContainer.makeBaseballDIContainer()
        let flow = baseballSceneDIContainer.makeBaseballSceneCoordinator(navigationController: navigationController)
        flow.start()
    }
}
