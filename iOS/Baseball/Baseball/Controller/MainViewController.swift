//
//  ViewController.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/04.
//

import UIKit
import Combine

class MainViewController: UIViewController {
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    private var gameListViewModel: GameListViewModel!
    private var subscriptions = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.gameListCollectionView.delegate = self
        self.gameListCollectionView.dataSource = self
        self.gameListCollectionView.register(GameListCell.nib, forCellWithReuseIdentifier: GameListCell.identifier)
    }
    
    func bind() {
        // nil을 넣는다?
        gameListViewModel.$gameList
            .receive(on: DispatchQueue.main)
            .sink(receiveCompletion: { (result) in
                switch result {
                case .failure(let error):
                    print(error)
                case .finished:
                    break
                }
            }, receiveValue: { [unowned self] _ in
                gameListCollectionView.reloadData()
            })
            .store(in: &subscriptions)
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

