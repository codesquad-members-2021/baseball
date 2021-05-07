//
//  PlayViewController.swift
//  Baseball
//
//  Created by sonjuhyeong on 2021/05/07.
//

import UIKit

class PlayViewController: UIViewController {

    @IBOutlet weak var BallCountTableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.BallCountTableView.delegate = self
        self.BallCountTableView.dataSource = self
        self.BallCountTableView.register(BallCountCell.nib, forCellReuseIdentifier: BallCountCell.identifier)
       
    }

}

extension PlayViewController: UITableViewDelegate {
    
}

extension PlayViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: BallCountCell.identifier, for: indexPath) as? BallCountCell else {
            return BallCountCell()
        }
        return cell
    }
    
    
}
