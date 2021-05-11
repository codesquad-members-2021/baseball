//
//  SBOView.swift
//  baseball
//
//  Created by zombietux on 2021/05/06.
//

import UIKit

@IBDesignable
final class SBOView: UIView {
    @IBOutlet weak var sboLabel: UILabel!
    @IBOutlet weak var countStack: UIStackView!
    
    private var countViews = [CountView]()
    var countColor = UIColor()

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
        insertCountViews()
    }
    
    func commonInit() {
        if let view = Bundle.main.loadNibNamed("SBOView", owner: self, options: nil)?.first as? UIView {
            view.frame = self.bounds
            self.addSubview(view)
        }
    }
    
    private func insertCountViews() {
        countViews = initCountViews()
        countViews.forEach {
            countStack.addArrangedSubview($0)
            $0.layer.cornerRadius = countStack.bounds.height / 2
        }
    }
    
    private func initCountViews() -> [CountView] {
        var views = [CountView]()
        let totalCount = 3
        for _ in 0 ..< totalCount {
            let view = CountView()
            views.append(view)
        }
        return views
    }
    
    func updateCountViews(count: Int) {
        hideAllCountView()
        for index in 0 ..< count {
            countViews[index].show(color: countColor)
        }
    }
    
    func hideAllCountView() {
        countViews.forEach { $0.hide() }
    }
}
