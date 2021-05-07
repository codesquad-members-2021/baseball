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
        Match(home: "Marvel", away: "Captin", id: "1"),
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

