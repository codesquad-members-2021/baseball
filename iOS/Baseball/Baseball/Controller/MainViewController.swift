//
//  ViewController.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/04.
//

import UIKit

class MainViewController: UIViewController {
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gameListCollectionView.delegate = self
        self.gameListCollectionView.dataSource = self
        self.gameListCollectionView.register(GameListCell.nib, forCellWithReuseIdentifier: GameListCell.identifier)
    }
}

extension MainViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 4
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: GameListCell.identifier, for: indexPath) as? GameListCell else {
            return GameListCell()
        }
        return cell
        
    }
}

extension MainViewController: UICollectionViewDelegate, UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let width = collectionView.bounds.width - 10
        let height = (collectionView.bounds.height) / 5 - 10
        
        return CGSize(width: width, height: height)
    }
}

