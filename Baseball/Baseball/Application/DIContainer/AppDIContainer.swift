//
//  AppDIContainer.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import Foundation

class AppDIContainer {
    lazy var networkService = DefaultNetworkService()
    
    func makeBaseballDIContainer() -> BaseballSceneDIContainer {
        let dependencies = BaseballSceneDIContainer.Dependencies.init(apiNetwork: networkService)
        return BaseballSceneDIContainer(dependencies: dependencies)
    }
}
