//
//  ScoresViewController.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import UIKit

class ScoresViewController: UIViewController {
    
    @IBOutlet var awayScoreLabel: [UILabel]!
    @IBOutlet var homeScoreLabel: [UILabel]!
    @IBOutlet weak var playerInformationTableView: UITableView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.playerInformationTableView.delegate = self
        self.playerInformationTableView.dataSource = self
        self.playerInformationTableView.register(PlayerInformationCell.nib, forCellReuseIdentifier: PlayerInformationCell.identifier)
    }


}

extension ScoresViewController: UITableViewDelegate {
    
}

extension ScoresViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 7
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: PlayerInformationCell.identifier, for: indexPath) as? PlayerInformationCell else {
            return PlayerInformationCell()
        }
        return cell
    }
    
    
}
