//
//  ViewController.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/03.
//

import UIKit
import Combine

enum GameListSection: CaseIterable {
    case main
}

class GameListViewController: UIViewController {
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    @IBOutlet weak var gameListImageView: UIImageView!
    @IBOutlet weak var gameListLabel: UILabel!
    
    var viewModel: GameListViewModel!
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
        
        let str = NSMutableAttributedString(string: "Game List", attributes: [
            NSMutableAttributedString.Key.foregroundColor : UIColor(named: "retroIvory"),
            NSMutableAttributedString.Key.strokeColor : UIColor(named: "retroBrown"),
            NSMutableAttributedString.Key.strokeWidth : -5,
            NSMutableAttributedString.Key.font : UIFont.systemFont(ofSize: 80.0)
            ])
            
        gameListLabel.attributedText = str
        gameListLabel.font = UIFont(name: "AmericanCaptain", size: 100)
        
        UIView.animate(withDuration:1,
        delay: 0,
        options: [.repeat, .autoreverse],
        animations: {
            self.gameListLabel.center.y -= CGFloat(10)
            print("1")
        },
        completion: nil)
        print("injection end")
        viewModel.fetchGameList()
    }
    
    func depend(viewModel: GameListViewModel) {
        self.viewModel = viewModel
    }
    
    func configureDataSource() -> UICollectionViewDiffableDataSource<GameListSection, String> {
        let dataSource = UICollectionViewDiffableDataSource<GameListSection, String>(collectionView: gameListCollectionView) { (collectionView, indexPath, icon) -> UICollectionViewCell? in
     
            let tempHomeTeams = ["HAWKS", "HAWKS", "HULKS", "JEJE"]
            let tempAwayTeams = ["BATMEN", "BATMEN", "JOKERS", "HONG"]
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameListCollectionViewCell", for: indexPath) as! GameListCollectionViewCell
            cell.homeTeamLabel.text = tempHomeTeams[indexPath.row]
            cell.awayTeamLabel.text = tempAwayTeams[indexPath.row]
            cell.gameNumberLabel.text = "Game 1"
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
        return CGSize(width: self.gameListCollectionView.frame.width, height: self.gameListCollectionView.frame.height / 5)
    }
}
