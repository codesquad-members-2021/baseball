//
//  MatchCell.swift
//  baseball
//
//  Created by zombietux on 2021/05/04.
//

import UIKit
import RxSwift

class MatchCell: UICollectionViewCell {
    static let reuseIdentifier = "MatchCell"
    private var disposeBag = DisposeBag()
    
    @IBOutlet weak var dimView: UIView!
    @IBOutlet weak var numberLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    
    func configureCell(_ match: Match) {
        self.homeTeamLabel.text = match.home
        self.awayTeamLabel.text = match.away
    }
    
    override func prepareForReuse() {
        disposeBag = DisposeBag()
    }
}
