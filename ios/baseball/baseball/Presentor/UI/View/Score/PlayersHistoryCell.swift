//
//  PlayersHistoryCell.swift
//  baseball
//
//  Created by zombietux on 2021/05/10.
//

import UIKit
import RxSwift

class PlayersHistoryCell: UICollectionViewCell {
    static let reuseIdentifier = "PlayersHistoryCell"
    private var disposeBag = DisposeBag()
    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var plateAppearancesLabel: UILabel!
    @IBOutlet weak var hitLabel: UILabel!
    @IBOutlet weak var outLabel: UILabel!
    @IBOutlet weak var avgLabel: UILabel!
    
    override func prepareForReuse() {
        disposeBag = DisposeBag()
    }
}
