//
//  GamePlayViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/06.
//

import UIKit

class GamePlayViewController: UIViewController {

    @IBOutlet weak var groundView: GroundView!
    @IBOutlet weak var pitchHistoryTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        pitchHistoryTableView.delegate = self
        pitchHistoryTableView.dataSource = self
    }
}

extension GamePlayViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        2
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "PitchHistoryCell") as? PitchHistoryCell else {
            return UITableViewCell()
        }
        
        return cell
    }
    
    
}

extension GamePlayViewController: UITableViewDelegate {
    
}
