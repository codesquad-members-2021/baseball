import UIKit

class ScoreCell: UITableViewCell {
    
    static let identifier = "ScoreCell"
    
    @IBOutlet weak var batterLabel: UILabel!
    @IBOutlet weak var atBatLabel: UILabel!
    @IBOutlet weak var hitsLabel: UILabel!
    @IBOutlet weak var outLabel: UILabel!
    @IBOutlet weak var averageLabel: UILabel!
    
    func configure(_ info: PlayerInfo) {
        self.batterLabel.text = info.playerName
        self.atBatLabel.text = "\(info.bat)"
        self.hitsLabel.text = "\(info.hits)"
        self.outLabel.text = "\(info.out)"
        self.averageLabel.text = info.bat == 0 ? "0":"\(info.hits/info.bat)"
    }
}
