//
//  CALayer+Extension.swift
//  Baseball
//
//  Created by 지북 on 2021/05/07.
//

import UIKit

extension CALayer {
    func addBorder(_ arr_edge: [UIRectEdge], color: UIColor, thickness: CGFloat) {
        for edge in arr_edge {
            let border = CALayer()
            switch edge {
            case UIRectEdge.top:
                border.frame = CGRect.init(x: 0, y: 0, width: frame.width, height: thickness)
                break
            case UIRectEdge.bottom:
                border.frame = CGRect.init(x: 0, y: frame.height - thickness, width: frame.width, height: thickness)
                break
            case UIRectEdge.left:
                border.frame = CGRect.init(x: 0, y: 0, width: thickness, height: frame.height)
                break
            case UIRectEdge.right:
                border.frame = CGRect.init(x: frame.width - thickness, y: 0, width: thickness, height: frame.height)
                break
            default:
                break
            }
            border.backgroundColor = color.cgColor;
            self.addSublayer(border)
        }
    }
}
