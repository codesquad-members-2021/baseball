//
//  PitchInfoCell.swift
//  baseball
//
//  Created by zombietux on 2021/05/09.
//

import UIKit

class PitchInfoCell: UICollectionViewCell {
    static let reuseIdentifier = "PitchInfoCell"
    
    @IBOutlet weak var pitchOrderView: PitchOrderView!
    @IBOutlet weak var sboLabel: UILabel!
    @IBOutlet weak var countLabel: UILabel!
    
    //수정 필요 PitchInfo 데이터타입
    func configureCell(order: Int, pitchInfo: [Bool]) {
        pitchOrderView.pitchOrderLabel.text = "\(order)"
        sboLabel.text = "스트라이크" //변경
        countLabel.text = "1-3" //변경
    }
}
