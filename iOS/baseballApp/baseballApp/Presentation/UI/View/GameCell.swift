import UIKit

class GameCell: UICollectionViewCell {
    static let identifier = "GameCell"
    
    @IBOutlet weak var gameIdLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupCellView()
    }
       
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupCellView()
    }
    
    func configureCell(game: Game) {
        gameIdLabel.text = GameViewModel.formatGameID(id: game.id)
        homeTeamLabel.text = game.home
        awayTeamLabel.text = game.away
    }
}

//MARK: -AddTapGesture
private extension GameCell {
    private func setupCellView() {
        layer.masksToBounds = true
        layer.cornerRadius = 15
    }
}
