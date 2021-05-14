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
    @IBOutlet weak var recordsSegmented: UISegmentedControl!
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
        configureSegmentedControl()
        self.gameScoreTableView.delegate = self
        self.gameScoreTableView.dataSource = self
    }
    
    private func bind(to viewModel: GameScoreViewModel) {
        bindRecordsTableView(to: viewModel)
        bindErrorMessage(to: viewModel)
    }
    
    private func bindRecordsTableView(to viewModel: GameScoreViewModel ) {
        viewModel.$selectedPlayerTeam.receive(on: DispatchQueue.main)
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
    
    private func configureSegmentedControl() {
        recordsSegmented.addTarget(self, action: #selector(segconChange(segcon:)), for: UIControl.Event.valueChanged)
    }
    
    @objc func segconChange(segcon: UISegmentedControl) {
        viewModel.setSelectedTeam(index: segcon.selectedSegmentIndex)
    }
    
    func configureStackView() {
        homeTeamScore.layer.addBorder([.top], color: .black, thickness: 0.75)
        awayTeamScore.layer.addBorder([.bottom], color: .black, thickness: 0.75)
    }
}

extension GameScoreViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return viewModel.selectedPlayerTeam.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = gameScoreTableView.dequeueReusableCell(withIdentifier: "GameScoreTableViewCell") as? GameScoreTableViewCell else { return UITableViewCell() }
        cell.configure(playerRecord: viewModel.selectedPlayerTeam[indexPath.row])
        return cell
    }

    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let view = RecordsTableViewHeader.nib().instantiate(withOwner: nil, options: nil)[0] as! RecordsTableViewHeader
        return view
    }
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        return UIView()
    }
}
