//
//  ScoreView.swift
//  baseball
//
//  Created by zombietux on 2021/05/04.
//

import UIKit

class ScoreView: UIView {
    
    @IBOutlet weak var awayScoreLabel: UILabel!
    @IBOutlet weak var homeScoreLabel: UILabel!
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    func commonInit() {
        let view = Bundle.main.loadNibNamed("ScoreView", owner: self, options: nil)?.first as! UIView
        view.frame = self.bounds
        self.addSubview(view)
    }
}
