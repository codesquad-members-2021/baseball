//
//  ControllerFactory.swift
//  baseball-game
//
//  Created by Lia on 2021/05/11.
//

import UIKit

class ControllerFactory {
    static func instantiate(viewController: Instantiatable.Type) -> UIViewController {
        return viewController.instantiate()
    }
}

protocol Instantiatable {
    static func instantiate() -> UIViewController
}
