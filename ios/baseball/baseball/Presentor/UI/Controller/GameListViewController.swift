//
//  ViewController.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/04.
//

import UIKit
import RxSwift
import RxCocoa

class GameListViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
  
    private var viewModel = MatchViewModel()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        viewModel.matchs
            .observe(on: MainScheduler.instance)
            .bind(to: collectionView.rx.items(cellIdentifier: MatchCell.reuseIdentifier, cellType: MatchCell.self)) { index, item, cell in
                cell.awayTeamLabel.text = item.away
                cell.homeTeamLabel.text = item.home
                cell.numberLabel.text = "GAME \(index+1)"
            }
            .disposed(by: disposeBag)
        
        collectionView.rx.modelSelected(Match.self).subscribe(onNext: { [weak self] item in
            self?.showPlayTab(id: item.id)
        })
        .disposed(by: disposeBag)
    }
    
    private func showPlayTab(id: String) {
        guard let mainTabBarController = storyboard?.instantiateViewController(identifier: "MainTabBarController") else { return }
        mainTabBarController.modalPresentationStyle = .fullScreen
        guard let playViewController = mainTabBarController.children.first as? PlayViewController else { return }
        playViewController.initId(id)
        present(mainTabBarController, animated: true, completion: .none)
    }
}

