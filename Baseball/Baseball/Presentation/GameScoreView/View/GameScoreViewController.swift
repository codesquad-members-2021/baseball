//
//  GameScoreViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/11.
//

import UIKit

class GameScoreViewController: UIViewController {

    @IBOutlet weak var homeTeamScore: UIStackView!
    @IBOutlet weak var awayTeamScore: UIStackView!
    @IBOutlet weak var gameScoreTableView: UITableView!
    
    private var viewModel: GameScoreViewModel!
    
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
        configureStackView()
        tableViewDelegate()
    }
    
    func configureStackView() {
        homeTeamScore.layer.addBorder([.top], color: .black, thickness: 0.75)
        awayTeamScore.layer.addBorder([.bottom], color: .black, thickness: 0.75)
    }
    
    func tableViewDelegate() {
        self.gameScoreTableView.delegate = self
        self.gameScoreTableView.dataSource = self
    }
}

extension GameScoreViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = gameScoreTableView.dequeueReusableCell(withIdentifier: "GameScoreTableViewCell") as? GameScoreTableViewCell else { return UITableViewCell() }
        return cell
    }
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return "a"
    }
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        return UIView()
    }
}
