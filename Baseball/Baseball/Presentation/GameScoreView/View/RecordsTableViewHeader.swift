//
//  RecordsTableViewHeader.swift
//  Baseball
//
//  Created by 지북 on 2021/05/14.
//

import UIKit

class RecordsTableViewHeader: UIView {

    static let identifierName = "RecordsTableViewHeader"
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    static let nib = {
        return UINib(nibName: identifierName, bundle: nil)
    }
}
