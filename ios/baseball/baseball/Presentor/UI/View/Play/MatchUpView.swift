//
//  MatchUpView.swift
//  baseball
//
//  Created by zombietux on 2021/05/04.
//

import UIKit

final class MatchUpView: UIView {
    
    @IBOutlet weak var pitcherNameLabel: UILabel!
    @IBOutlet weak var batterNameLabel: UILabel!
    @IBOutlet weak var numberOfPitchingLabel: UILabel!
    @IBOutlet weak var battingHistoryLabel: UILabel!
    @IBOutlet weak var isOffenseCheckbox: UIImageView!
    @IBOutlet weak var isDefenceCheckbox: UIImageView!
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    func commonInit() {
        if let view = Bundle.main.loadNibNamed("MatchUpView", owner: self, options: nil)?.first as? UIView {
            view.frame = self.bounds
            self.addSubview(view)
        }
    }
    
    func configurePitcherMatchUpView(_ pitcher: Pitcher) {
        pitcherNameLabel.text = pitcher.name
        numberOfPitchingLabel.text = "#\(pitcher.numberOfPitching)"
    }
    
    func configureBatterMatchUpView(_ batter: Batter) {
        batterNameLabel.text = batter.name
        battingHistoryLabel.text = "\(batter.plateAppearances)타수\(batter.hit)안타"
    }
}
