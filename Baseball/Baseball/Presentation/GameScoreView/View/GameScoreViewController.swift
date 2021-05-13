//
//  GameScoreViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit
import Combine

class GameScoreViewController: UIViewController, Alertable {

    @IBOutlet weak var scoreView: UIView!
    @IBOutlet weak var homeTeamScore: UIStackView!
    @IBOutlet weak var awayTeamScore: UIStackView!
    @IBOutlet weak var gameScoreTableView: UITableView!
    
    private var viewModel: GameScoreViewModel!
    private var subscriptions = Set<AnyCancellable>()
    
    static let storyboardName = "Main"
    static let storyboardID = "GameScoreViewController"
    
    static func create(with viewModel: GameScoreViewModel) -> GameScoreViewController {
        let storyboard = UIStoryboard(name: storyboardName, bundle: Bundle.main)
        guard let vc = storyboard.instantiateViewController(identifier: storyboardID) as? GameScoreViewController else {
            return GameScoreViewController()
        }
        vc.viewModel = viewModel
        return vc
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind(to: viewModel)
        configureStackView()
        self.gameScoreTableView.delegate = self
        self.gameScoreTableView.dataSource = self
    }
    
    private func bind(to viewModel: GameScoreViewModel) {
        bindMatchUpGames(to: viewModel)
        bindErrorMessage(to: viewModel)
    }
    
    private func bindMatchUpGames(to viewModel: GameScoreViewModel) {
        viewModel.$homeTeamPlayersRecords.receive(on: DispatchQueue.main)
            .sink { [weak self] _ in
                self?.gameScoreTableView.reloadData()
            }
            .store(in: &subscriptions)
    }
    
    private func bindErrorMessage(to viewModel: GameScoreViewModel) {
        viewModel.$error.receive(on: DispatchQueue.main)
            .sink { [weak self] value in
                self?.showError(with: value)
            }
            .store(in: &subscriptions)
    }
    
    private func showError(with error: String) {
        guard !error.isEmpty else { return }
        showAlert(title: "Error", message: error)
    }
    
    func configureStackView() {
        homeTeamScore.layer.addBorder([.top], color: .black, thickness: 0.75)
        awayTeamScore.layer.addBorder([.bottom], color: .black, thickness: 0.75)
    }
}

extension GameScoreViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return viewModel.homeTeamPlayersRecords.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = gameScoreTableView.dequeueReusableCell(withIdentifier: "GameScoreTableViewCell") as? GameScoreTableViewCell else { return UITableViewCell() }
        cell.configure(playerRecord: viewModel.homeTeamPlayersRecords[indexPath.row])
        return cell
    }
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return "a"
    }
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        return UIView()
    }
}
