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
    var dataSource: UICollectionViewDiffableDataSource<GameListSection , Game>!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        gameListImageView.backgroundColor = UIColor(patternImage: UIImage(named: "baseBallPattern")!)
        self.gameListCollectionView.backgroundColor = .clear
        
        gameListCollectionView.register(UINib(nibName: "GameListCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "GameListCollectionViewCell")
        gameListCollectionView.dataSource = dataSource
        gameListCollectionView.delegate = self
        
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
        
        },
        completion: nil)
        
        self.dataSource = configureDataSource()
        bind()
    }
    
    func depend(viewModel: GameListViewModel) {
        self.viewModel = viewModel
    }
    
    func bind() {
        viewModel.fetchGameList()
        viewModel.didUpdateGameList { [weak self] (gameList) in
//            self?.dataSource = self?.configureDataSource()
            self?.performUIUpdate(with: gameList)
        }
    }
    
    func configureDataSource() -> UICollectionViewDiffableDataSource<GameListSection, Game> {
        let dataSource = UICollectionViewDiffableDataSource<GameListSection, Game>(collectionView: gameListCollectionView) { (collectionView, indexPath, game) -> UICollectionViewCell? in
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameListCollectionViewCell", for: indexPath) as! GameListCollectionViewCell
            cell.homeTeamLabel.text = game.myTeam.name
            cell.awayTeamLabel.text = game.opponentTeam.name
            cell.gameNumberLabel.text = "Game \(indexPath.row + 1)"
            return cell
        }
        return dataSource
    }
    
    func updateSnapshot(with gameList: GameList) {
        var snapshot = NSDiffableDataSourceSnapshot<GameListSection, Game>()
        snapshot.appendSections(GameListSection.allCases)
        snapshot.appendItems(gameList.games, toSection: GameListSection.main)
        dataSource.apply(snapshot)
    }
    
    func performUIUpdate(with gameList: GameList) {
        DispatchQueue.main.async {
            self.updateSnapshot(with: gameList)
        }
    }
}

extension GameListViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: self.gameListCollectionView.frame.width, height: self.gameListCollectionView.frame.height / 5)
    }
}
