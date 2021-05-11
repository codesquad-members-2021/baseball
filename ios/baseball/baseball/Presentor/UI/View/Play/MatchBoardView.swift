//
//  MatchBoardView.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class MatchBoardView: UIView {
    @IBOutlet weak var sboBoardView: SBOBoardView!
    @IBOutlet weak var groundView: GroundView!
    @IBOutlet weak var inningInfoLabel: UILabel!
    @IBOutlet weak var pitchButton: PitchButton!
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    func commonInit() {
        let view = Bundle.main.loadNibNamed("MatchBoardView", owner: self, options: nil)?.first as! UIView
        view.frame = self.bounds
        self.addSubview(view)
    }
    
    func configureSBOBoardView(sbo: SBO) {
        sboBoardView.strikeView.updateCountViews(count: sbo.strike)
        sboBoardView.ballView.updateCountViews(count: sbo.ball)
        sboBoardView.outView.updateCountViews(count: sbo.out)
    }
    
    func configureInningInfo(inningInfo: InningInfo) {
        inningInfoLabel.text = "\(inningInfo.inningCount)회\(inningInfo.makeUseHalf()) \(inningInfo.makeUserPlay())"
    }
}
