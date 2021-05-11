//
//  SBOBoardView.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

final class SBOBoardView: UIView {
    @IBOutlet weak var strikeView: SBOView!
    @IBOutlet weak var ballView: SBOView!
    @IBOutlet weak var outView: SBOView!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        commonInit()
        configureUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
        configureUI()
    }
    
    func commonInit() {
        if let view = Bundle.main.loadNibNamed("SBOBoardView", owner: self, options: nil)?.first as? UIView {
            view.frame = self.bounds
            self.addSubview(view)
        }
    }
    
    private func configureUI() {
        configureSBOLabels()
        configureSBOCountColor()
    }
    
    private func configureSBOLabels() {
        strikeView.sboLabel.text = "S"
        ballView.sboLabel.text = "B"
        outView.sboLabel.text = "O"
    }
    
    private func configureSBOCountColor() {
        strikeView.countColor = .systemYellow
        ballView.countColor = .systemGreen
        outView.countColor = .systemRed
    }
}
