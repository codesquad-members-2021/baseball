//
//  BaseManager.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

struct BaseChanged: Decodable {
    var first: BaseStatus?
    var second: BaseStatus?
    var third: BaseStatus?
    
    struct BaseStatus: Decodable {
        var baseIn: Bool
        var baseOut: Bool
        
        enum CodingKeys: String, CodingKey{
            case baseIn = "in"
            case baseOut = "out"
        }
    }
}

class BaseManager {
    
    private var first: Bool
    private var second: Bool
    private var third: Bool
    
    init(first: Bool, second: Bool, third: Bool) {
        self.first = first
        self.second = second
        self.third = third
    }
    
    convenience init() {
        self.init(first: false, second: false, third: false)
    }
    
    func reset() {
        self.first = false
        self.second = false
        self.third = false
        
        notiBaseChanged(movement: BaseMovement.reset)
    }
    
    static let notiName = Notification.Name.init("baseChanged")
    
    private func notiBaseChanged(movement: BaseMovement) {
        let updateInfo: [String: Any] = ["movement": movement]
        NotificationCenter.default.post(name: BaseManager.notiName, object: nil, userInfo: updateInfo)
    }
    
    func update(with baseInfo: BaseChanged) {
        
        if let thirdChanged = baseInfo.third {
            if thirdChanged.baseOut { thirdToHome() }
        }
        
        if let secondChanged = baseInfo.second {
            if secondChanged.baseOut { secondToThird() }
        }
        
        if let firstChanged = baseInfo.first {
            if firstChanged.baseOut { firstToSecond() }
            if firstChanged.baseIn { homeToFirst() }
        }
        
    }
    
    private func thirdToHome() {
        self.third = false
        
        notiBaseChanged(movement: BaseMovement.thirdToHome)
    }
    
    private func secondToThird() {
        self.second = false
        self.third = true
        
        notiBaseChanged(movement: BaseMovement.secondToThird)
    }
    
    private func firstToSecond() {
        self.first = false
        self.second = true
        
        notiBaseChanged(movement: BaseMovement.firstToSecond)
    }
    
    private func homeToFirst() {
        self.first = true
        
        notiBaseChanged(movement: BaseMovement.homeToFirst)
    }
    
}

enum BaseMovement {
    case homeToFirst
    case firstToSecond
    case secondToThird
    case thirdToHome
    case reset
}
