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
    
    private let gameList = [
        Match(home: "Marvel", away: "Captin", id: "1"),
    ]
    
    private var viewModel = MatchViewModel()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
//        self.collectionView.dataSource = self
//        viewModel.fetchMatchs()
        viewModel.matchs
            .observe(on: MainScheduler.instance)
            .bind(to: collectionView.rx.items(cellIdentifier: MatchCell.reuseIdentifier, cellType: MatchCell.self)) { index, item, cell in
                cell.awayTeamLabel.text = item.away
                cell.homeTeamLabel.text = item.home
                cell.numberLabel.text = "GAME \(index+1)"
            }
            .disposed(by: disposeBag)
    }
}

//extension GameListViewController: UICollectionViewDataSource {
//    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
//        return self.gameList.count
//    }
//    
//    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
//        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MatchCell.reuseIdentifier, for: indexPath) as? MatchCell else {
//            return UICollectionViewCell()
//        }
//        
//        let match = self.gameList[indexPath.row]
//        cell.configureCell(match)
//        
//        return cell
//    }
//}

