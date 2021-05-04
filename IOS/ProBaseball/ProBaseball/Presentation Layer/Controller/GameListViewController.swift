//
//  ViewController.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/03.
//

import UIKit

enum Section: CaseIterable {
    case main
}

class GameListViewController: UIViewController {
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    lazy var dataSource = configureDataSource()
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gameListCollectionView.backgroundColor = .red
        gameListCollectionView.register(UINib(nibName: "GameListCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "GameListCollectionViewCell")
        gameListCollectionView.dataSource = dataSource
        gameListCollectionView.delegate = self
        updateSnapshot()
    }
    
    func configureDataSource() -> UICollectionViewDiffableDataSource<Section, String> {
        let dataSource = UICollectionViewDiffableDataSource<Section, String>(collectionView: gameListCollectionView) { (collectionView, indexPath, icon) -> UICollectionViewCell? in
     
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameListCollectionViewCell", for: indexPath) as! GameListCollectionViewCell
            cell.homeTeamLabel.text = "hhhh"
            return cell
        }
        return dataSource
    }
    
    func updateSnapshot(animatingChange: Bool = false) {
        var snapshot = NSDiffableDataSourceSnapshot<Section, String>()
        snapshot.appendSections(Section.allCases)
        snapshot.appendItems(["sdf"], toSection: Section.main)
     
        dataSource.apply(snapshot, animatingDifferences: false)
    }
}

extension GameListViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: self.gameListCollectionView.frame.width, height: self.gameListCollectionView.frame.height / 6)
    }
}
