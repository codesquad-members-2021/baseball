//
//  GroundView.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class GroundView: UIView {
    @IBOutlet weak var firstBaseView: RoundedView!
    @IBOutlet weak var secondBaseView: RoundedView!
    @IBOutlet weak var thirdBaseView: RoundedView!
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    func commonInit() {
        let view = Bundle.main.loadNibNamed("GroundView", owner: self, options: nil)?.first as! UIView
        view.frame = self.bounds
        self.addSubview(view)
    }
}
