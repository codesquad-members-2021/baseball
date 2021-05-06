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
    private var cancellable = Set<AnyCancellable>()
    
    
    func setModel(with gameInfo: GameInfo) {
        self.gameInfo = gameInfo
    }
    
    //MARK: GET
    
    func request() {
        NetworkManager.request(type: [Game].self, url: EndPoint.url(path: "")!)
            .receive(on: DispatchQueue.main)
            .sink { error in
                print(error)
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
        NetworkManager.post(url: EndPoint.url(path: "")!, data: gameInfo)
            .receive(on: DispatchQueue.main)
            .sink { error in
                print(error)
            } receiveValue: { _ in
                print("success")
            }
            .store(in: &cancellable)
    }
    
}

enum NotificationName {
    static let fetched = Notification.Name("fetched")
}
