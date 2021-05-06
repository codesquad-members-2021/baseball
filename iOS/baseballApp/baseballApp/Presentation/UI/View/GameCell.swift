import UIKit
import RxSwift

class GameCell: UICollectionViewCell {
    

    @IBOutlet weak var gameIdLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    private let disposBag = DisposeBag()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupCellView()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupCellView()
    }
    
    func configureCell(game: Game) {
        gameIdLabel.text = "Game \(game.id)"
        homeTeamLabel.text = game.home
        awayTeamLabel.text = game.away
    }
}

//MARK: -AddTapGesture

private extension GameCell {
    private func setupCellView() {
        layer.masksToBounds = true
        layer.cornerRadius = 15
        setupTapGesture()
    }
    
    private func setupTapGesture() {
        let tapGesture = UITapGestureRecognizer()
        self.addGestureRecognizer(tapGesture)
        
        tapGesture.rx.event
            .bind(onNext: { recognizer in
                API.shared.checkGameStatus()
                    .subscribe(onNext: { value in
                        print(value)
                    }, onError: { error in
                        print(error.localizedDescription)
                    }).disposed(by: self.disposBag)
            })
            .disposed(by: disposBag)
    }
}
