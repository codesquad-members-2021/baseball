import UIKit
import RxSwift

class HomeViewController: UIViewController {
 
    @IBOutlet weak var mainCollectionView: UICollectionView!
    private let viewModel = GameViewModel()
    private var delegate = MainCollectionViewDelegate()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bindCollectionView()
        mainCollectionView.delegate = delegate
    }
    
    private func bindCollectionView() {
        viewModel.getGameInfo()
        viewModel.games
            .bind(to: mainCollectionView.rx.items(cellIdentifier: Identifier.GameCell, cellType: GameCell.self)) {
            _, game, cell in
            dump(game)
            cell.configureCell(game: game)
        }.disposed(by: disposeBag)
    }
}

