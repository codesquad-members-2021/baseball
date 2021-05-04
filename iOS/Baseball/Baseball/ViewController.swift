//
//  ViewController.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/04.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gameListCollectionView.delegate = self
        self.gameListCollectionView.dataSource = self
        self.gameListCollectionView.register(GameListCell.nib, forCellWithReuseIdentifier: GameListCell.identifier)
    }
}

extension ViewController: UICollectionViewDataSource {
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

extension ViewController: UICollectionViewDelegate {}

