//
//  ViewController.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/04.
//

import UIKit

class GameListViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    
    private let gameList = [
        Match(id: "1", home: "Captin", away: "Marvel"),
        Match(id: "2", home: "Twins", away: "Tigers"),
        Match(id: "3", home: "Giants", away: "Dodgers"),
        Match(id: "4", home: "Heroes", away: "Lions"),
        Match(id: "5", home: "Heroes", away: "Lions"),
        Match(id: "6", home: "Heroes", away: "Lions"),
        Match(id: "7", home: "Heroes", away: "Lions"),
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.collectionView.dataSource = self
    }
}

extension GameListViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return self.gameList.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MatchCell.reuseIdentifier, for: indexPath) as? MatchCell else {
            return UICollectionViewCell()
        }
        
        let match = self.gameList[indexPath.row]
        cell.configureCell(match)
        
        return cell
    }
}

