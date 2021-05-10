import UIKit
import RxSwift

class HomeViewController: UIViewController {
 
    @IBOutlet weak var mainCollectionView: UICollectionView!
    private let viewModel = GameViewModel()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bindCollectionView()
        setupCollectionViewDelegate()
    }
    
    private func bindCollectionView() {
        viewModel.getGameInfo()
        viewModel.games
            .bind(to: mainCollectionView.rx.items(cellIdentifier: Identifier.GameCell, cellType: GameCell.self)) {
            _, game, cell in
            cell.configureCell(game: game)
        }.disposed(by: disposeBag)
    }
    
    private func setupCollectionViewDelegate() {
        mainCollectionView.rx.itemSelected
            .subscribe(onNext: { [weak self] indexPath in
                let tabBarVC = self?.storyboard?.instantiateViewController(identifier: "TabBar")
                self?.present(tabBarVC!, animated: true, completion: nil)
            }, onError: { error in
                print(error.localizedDescription)
            })
            .disposed(by: disposeBag)
    }
}
