//
//  GameListViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/04.
//

import UIKit

class GameListViewController: UIViewController {
    
    static let storyboardName = "Main"
    static let storyboardID = "GameListViewController"
    
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    private var viewModel: GameListViewModel!
    
    static func create(with viewModel: GameListViewModel) -> GameListViewController {
        let storyboard = UIStoryboard(name: storyboardName, bundle: Bundle.main)
        guard let vc = storyboard.instantiateViewController(identifier: storyboardID) as? GameListViewController else {
            return GameListViewController()
        }
        vc.viewModel = viewModel
        return vc
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        gameListCollectionView.dataSource = self
        gameListCollectionView.delegate = self
    }
}

extension GameListViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        viewModel.matchUpGames.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameListCell", for: indexPath) as? GameListCell else { return UICollectionViewCell() }
        
        cell.configure(game: viewModel.matchUpGames[indexPath.item])
        return cell
    }
}

extension GameListViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 40
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let width = collectionView.bounds.width
        let height = CGFloat(128)
        return CGSize(width: width, height: height)
    }
}
