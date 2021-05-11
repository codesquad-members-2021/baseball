//
//  SelectViewModel.swift
//  baseball-game
//
//  Created by Lia on 2021/05/04.
//

import Foundation
import Combine

class SelectViewModel {
    
    private(set) var gameInfo: GameInfo!
    private var networkManager: NetworkManageable
    private var cancellable = Set<AnyCancellable>()
    
    init(networkManager: NetworkManageable = NetworkManager()) {
        self.networkManager = networkManager
    }
}


extension SelectViewModel {
    
    func setModel(with gameInfo: GameInfo) {
        self.gameInfo = gameInfo
    }
    
    //MARK: GET
    func request() {
        networkManager.get(type: [Game].self, url: EndPoint.url(path: "")!)
            .receive(on: DispatchQueue.main)
            .sink { error in
                print(error) ///사용자에게 에러 표시하는 부분 미구현
            } receiveValue: { games in
                self.fetch(data: games)
            }
            .store(in: &cancellable)
    }
    
    private func fetch(data: [Game]) {
        NotificationCenter.default.post(name: NotificationName.fetched, object: nil, userInfo: ["games": data])
    }
    
    func didFetchData(completion: @escaping ([Game]) -> Void) {
        NotificationCenter.default.publisher(for: NotificationName.fetched)
            .map{ ($0.userInfo as! [String:[Game]]) }
            .sink { (userInfo) in
                completion(userInfo["games"] ?? [])
            }.store(in: &cancellable)
    }
    
    //MARK: POST
    func postSelection(with gameInfo: GameInfo) {
        networkManager.post(url: EndPoint.url(path: "")!, data: gameInfo)
            .receive(on: DispatchQueue.main)
            .sink { error in
                print(error) ///사용자에게 에러 표시하는 부분 미구현
            } receiveValue: { _ in
                print("success") ///서버 POST 기능 미구현
            }
            .store(in: &cancellable)
    }
    
}

enum NotificationName {
    static let fetched = Notification.Name("fetched")
}
