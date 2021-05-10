//
//  ColorSet.swift
//  baseball-game
//
//  Created by Song on 2021/05/10.
//

import UIKit

enum ColorSet {
    
    enum BallCount {
        static let strike = UIColor(named: "Strike")!.cgColor
        static let ball = UIColor(named: "Ball")!.cgColor
        static let out = UIColor(named: "Out")!.cgColor
        static let border = UIColor.lightGray.cgColor
        static let text = UIColor.white.cgColor
        static let back = UIColor.black.cgColor
    }
    
    enum Ground {
        static let green = UIColor(named: "GroundGreen")!.cgColor
        static let bround = UIColor(named: "GroundBrown")!.cgColor
        static let base = UIColor(named: "Base")!.cgColor
        static let baseSelected = UIColor(named: "BaseSelected")!.cgColor
        static let home = UIColor(named: "Home")!.cgColor
        static let border = UIColor.darkGray.cgColor
    }

}
