//
//  RoundedView.swift
//  baseball
//
//  Created by zombietux on 2021/05/05.
//

import UIKit

@IBDesignable class RoundedView: UIView {
    @IBInspectable
    var cornerRadius: CGFloat {
        get { return layer.cornerRadius }
        set {
            layer.cornerRadius = newValue
            layer.masksToBounds = newValue > 0
        }
    }
    
    @IBInspectable
    var borderWidth: CGFloat {
        get { return layer.borderWidth }
        set { layer.borderWidth = newValue }
    }
    
    @IBInspectable
    var borderColor: UIColor? {
        get {
            guard let color = layer.borderColor else {
                return nil
            }
            return UIColor(cgColor: color)
        }
        set { layer.borderColor = newValue?.cgColor }
    }
}

@IBDesignable class RotateView: UIView {
    @IBInspectable var rotation: Double = 0 {
            didSet {
                rotateView(rotation: rotation)
            }
        }

        func rotateView(rotation: Double)  {
            self.transform = CGAffineTransform(rotationAngle: CGFloat(.pi/2 + rotation))
        }
}
