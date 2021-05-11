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
            .bind(to: mainCollectionView.rx.items(cellIdentifier: GameCell.identifier, cellType: GameCell.self)) {
            row, game, cell in
                
                cell.configureCell(game: game)
                cell.alpha = 0
                UIView.animate(withDuration: 0.5, delay: 0.5 * Double(row)) {
                    cell.alpha = 1
                }
        }.disposed(by: disposeBag)
    }
    
    private func setupCollectionViewDelegate() {
        mainCollectionView.rx.itemSelected
            .subscribe(onNext: { [weak self] indexPath in
                let tabBarController = self?.storyboard?.instantiateViewController(identifier: "TabBarController")
                self?.present(tabBarController!, animated: true, completion: nil)
            }, onError: { error in
                
                print(error.localizedDescription)
            })
            .disposed(by: disposeBag)
    }
}
