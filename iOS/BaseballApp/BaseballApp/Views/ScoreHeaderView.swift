//
//  HeaderView.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/05.
//

import UIKit

class ScoreHeaderView: UIView {
    
    static let identifier = String(describing: ScoreHeaderView.self)

    @IBOutlet weak var awayTeamName: UILabel!
    @IBOutlet weak var homeTeamName: UILabel!
    @IBOutlet weak var awayTeamScore: UILabel!
    @IBOutlet weak var homeTeamScore: UILabel!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }
    
    func setup() {
        guard let headerView = Bundle.main.loadNibNamed(ScoreHeaderView.identifier, owner: self, options: nil)?.first as? ScoreHeaderView else {
            return
        }
        headerView.frame = bounds
        addSubview(headerView)
    }
    
    func configureTeamNames(away: String, home: String) {
        awayTeamName.text = away
        homeTeamName.text = home
    }
    
    func configureAway(score: Int) {
        awayTeamScore.text = "\(score)"
    }
    
    func configureHome(score: Int) {
        homeTeamScore.text = "\(score)"
    }
}
