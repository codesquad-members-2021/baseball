//
//  BaseballSceneDIContainer.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit

class BaseballSceneDIContainer: BaseballFlowCoordinatorDependencies {
    private var dependencies: Dependencies
    
    struct Dependencies {
        let apiNetwork: NetworkService
    }
    
    init(dependencies: Dependencies) {
        self.dependencies = dependencies
    }
    
    private func makeGameListRepository() -> GameListRepository {
        return DefaultGameListRepository(networkService: dependencies.apiNetwork)
    }
    
    private func makeFetchGameListUseCase() -> FetchGameListUseCase {
        return DefaultFetchGameListUseCase(gameListRepository: makeGameListRepository())
    }
    
    private func makeGameListViewModel() -> GameListViewModel {
        return GameListViewModel(fetchGameListUseCase: makeFetchGameListUseCase())
    }
    
    func makeGameListViewController() -> GameListViewController {
        return GameListViewController.create(with: makeGameListViewModel())
    }
    
    func makeBaseballSceneCoordinator(navigationController: UINavigationController) -> BaseballSceneFlowCoordinator {
        return BaseballSceneFlowCoordinator(navigationController: navigationController, dependencies: self)
    }
}
