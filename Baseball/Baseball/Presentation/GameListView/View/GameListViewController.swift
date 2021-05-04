//
//  GameListViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/04.
//

import UIKit

class GameListViewController: UIViewController {
    
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        gameListCollectionView.dataSource = self
        gameListCollectionView.delegate = self
    }
    
    func configure() {
        
    }
}

extension GameListViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        10
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameListCell", for: indexPath) as? GameListCell else { return UICollectionViewCell() }
        return cell
    }
}

extension GameListViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 40
    }
}
