//
//  GameListViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/04.
//

import UIKit
import Combine

class GameListViewController: UIViewController, Alertable {
    
    static let storyboardName = "Main"
    static let storyboardID = "GameListViewController"
    
    @IBOutlet weak var retryButton: UIButton!
    @IBOutlet weak var gameListCollectionView: UICollectionView!
    
    private var viewModel: GameListViewModel!
    private var subscriptions = Set<AnyCancellable>()
    
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
        bind(to: viewModel)
        gameListCollectionView.dataSource = self
        gameListCollectionView.delegate = self
    }
    
    @IBAction func didTappedRetryButton(_ sender: Any) {
        viewModel.fetchGameList()
        retryButton.isHidden = true
    }
    
    private func bind(to viewModel: GameListViewModel) {
        bindMatchUpGames(to: viewModel)
        bindErrorMessage(to: viewModel)
    }
    
    private func bindMatchUpGames(to viewModel: GameListViewModel) {
        viewModel.$matchUpGames.receive(on: DispatchQueue.main)
            .sink { [weak self] _ in
                self?.gameListCollectionView.reloadData()
            }
            .store(in: &subscriptions)
    }
    
    private func bindErrorMessage(to viewModel: GameListViewModel) {
        viewModel.$error.receive(on: DispatchQueue.main)
            .sink { [weak self] value in
                self?.showError(with: value)
            }
            .store(in: &subscriptions)
    }
    
    private func showError(with error: String) {
        guard !error.isEmpty else { return }
        retryButton.isHidden = false
        showAlert(title: "Error", message: error)
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

extension GameListViewController: UICollectionViewDelegate {
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        viewModel.didSelectItem(indexPath: indexPath)
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
