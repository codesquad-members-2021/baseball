//
//  ViewController.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/03.
//

import UIKit

enum GameListSection: CaseIterable {
    case main
}

class GameListViewController: UIViewController {
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    @IBOutlet weak var gameListImageView: UIImageView!
    @IBOutlet weak var gameListLabel: UILabel!
    
    lazy var dataSource = configureDataSource()
    override func viewDidLoad() {
        super.viewDidLoad()
        gameListImageView.backgroundColor = UIColor(patternImage: UIImage(named: "baseBallPattern")!)
        self.gameListCollectionView.backgroundColor = .clear
        gameListCollectionView.register(UINib(nibName: "GameListCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "GameListCollectionViewCell")
        gameListCollectionView.dataSource = dataSource
        gameListCollectionView.delegate = self
        updateSnapshot()
        
        self.gameListLabel.layer.shadowColor = UIColor(named: "retroBrown")?.cgColor
        self.gameListLabel.layer.shadowOffset = CGSize(width: 0, height: 6)
               self.gameListLabel.layer.shadowOpacity = 1.0
               self.gameListLabel.layer.shadowRadius = 0.0
        
        let str = NSAttributedString(string: "Game List", attributes: [
            NSAttributedString.Key.foregroundColor : UIColor(named: "retroIvory"),
            NSAttributedString.Key.strokeColor : UIColor(named: "retroBrown"),
            NSAttributedString.Key.strokeWidth : -5,
            NSAttributedString.Key.font : UIFont.systemFont(ofSize: 80.0)
                ])
            
        gameListLabel.attributedText = str
        gameListLabel.font = UIFont(name: "AmericanCaptain", size: 100)
    }
    
    func configureDataSource() -> UICollectionViewDiffableDataSource<GameListSection, String> {
        let dataSource = UICollectionViewDiffableDataSource<GameListSection, String>(collectionView: gameListCollectionView) { (collectionView, indexPath, icon) -> UICollectionViewCell? in
     
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameListCollectionViewCell", for: indexPath) as! GameListCollectionViewCell
            cell.homeTeamLabel.text = "hhhh"
            return cell
        }
        return dataSource
    }
    
    func updateSnapshot(animatingChange: Bool = false) {
        var snapshot = NSDiffableDataSourceSnapshot<GameListSection, String>()
        snapshot.appendSections(GameListSection.allCases)
        snapshot.appendItems(["sdf"], toSection: GameListSection.main)
     
        dataSource.apply(snapshot, animatingDifferences: false)
    }
}

extension GameListViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: self.gameListCollectionView.frame.width, height: self.gameListCollectionView.frame.height / 6)
    }
}
