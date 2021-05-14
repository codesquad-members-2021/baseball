//
//  AlertFactory.swift
//  baseball-game
//
//  Created by Song on 2021/05/14.
//

import UIKit

class AlertFactory {
    
    enum AlertType: String {
        case newInning = "새 이닝이 시작되었습니다!"
        case newScore = "점수가 바뀌었습니다!\n현재 점수: "
        
        var message: String {
            return rawValue
        }
    }
    
    static func createMessage(alertType: AlertType, info: String? = nil) -> String {
        switch alertType {
        case .newInning:
            return alertType.message
        case .newScore:
            return alertType.message + (info ?? "")
        }
    }
    
    static func scoreToMessage(with score: Score) -> String {
        return "\(score.home) - \(score.away)"
    }
    
    static func create(with message: String, buttonMessage: String? = "OK") -> UIAlertController {
        let alert = UIAlertController(title: nil, message: message, preferredStyle: .alert)
        let okAction = UIAlertAction(title: buttonMessage, style: .default, handler: nil)
        alert.addAction(okAction)
        return alert
    }
    
}
