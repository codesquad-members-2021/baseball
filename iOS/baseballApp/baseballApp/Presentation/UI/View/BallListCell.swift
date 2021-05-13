//
//  BallCountCell.swift
//  baseballApp
//
//  Created by 김지선 on 2021/05/12.
//

import UIKit

class BallListCell: UITableViewCell {
    static let identifier = "BallListCell"
    @IBOutlet weak var ballIDLabel: UILabel!
    @IBOutlet weak var ballTypeLabel: UILabel!
    @IBOutlet weak var strikeCountLabel: UILabel!
    @IBOutlet weak var ballCountLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
//        configureUI()
        // Initialization code
    }


    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
//        configureUI()
        // Configure the view for the selected state
    }
    
    func configure(id: Int, ball: String, with ballCount: BallCount) {
        transform = CGAffineTransform(scaleX: 1, y: -1)
        ballIDLabel.text = "\(id)"
        ballTypeLabel.text = ball == "S" ? "Strike" : "Ball"
        let (strike, ball) = ballCount.addBall(ball)
        strikeCountLabel.text = "\(strike)"
        ballCountLabel.text = "\(ball)"
    }
    
//    func configureUI() {
//        ballIDLabel.layer.cornerRadius = ballIDLabel.layer.bounds.width / 2
//
//    }
    
    
}
