import UIKit
import RxSwift

class HomeViewController: UIViewController {
 
    @IBOutlet weak var collectionView: UICollectionView!
    
    private let viewModel = GameViewModel()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bindCollectionView()
    }
    
    private func bindCollectionView() {
        viewModel.getGameInfo()
        viewModel.games.bind(to: collectionView.rx.items(cellIdentifier: "GameCell", cellType: GameCell.self)) {
            _, game, cell in
            dump(game)
            cell.configureCell(game: game)
        }.disposed(by: disposeBag)
    }
}

