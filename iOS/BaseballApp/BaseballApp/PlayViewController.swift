//
//  PlayViewController.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class PlayViewController: UIViewController {
    @IBOutlet weak var baseScrollView: UIScrollView!
    @IBOutlet weak var playInformationStackView: UIStackView!
    
    private let pitcherTableView: UITableView = {
        let tableView = UITableView()
        tableView.rowHeight = 44.0
        return tableView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pitcherTableView.dataSource = self
        pitcherTableView.register(PitcherHistoryTableViewCell.nib(), forCellReuseIdentifier: PitcherHistoryTableViewCell.identifier)
        configure()
    }
    
    func configure() {
        guard let groundView = Bundle.main.loadNibNamed("GroundView", owner: self, options: nil)?.first as? GroundView else { return }
        guard let currentPlayerView = Bundle.main.loadNibNamed("CurrentPlayerView", owner: self, options: nil)?.first as? CurrentPlayerView else { return }
        
        playInformationStackView.addArrangedSubview(groundView)
        playInformationStackView.addArrangedSubview(currentPlayerView)
        playInformationStackView.addArrangedSubview(pitcherTableView)
        
        groundView.heightAnchor.constraint(equalToConstant: view.frame.width).isActive = true
        currentPlayerView.heightAnchor.constraint(equalToConstant: 100.0).isActive = true
        NSLayoutConstraint.activate([
            pitcherTableView.heightAnchor.constraint(equalToConstant: 44 * 30),
            pitcherTableView.leadingAnchor.constraint(equalTo: playInformationStackView.leadingAnchor),
            pitcherTableView.trailingAnchor.constraint(equalTo: playInformationStackView.trailingAnchor),
        ])
    }
}

extension PlayViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 30
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: PitcherHistoryTableViewCell.identifier, for: indexPath) as! PitcherHistoryTableViewCell
        cell.backgroundColor = .systemRed
        return cell
    }
}
