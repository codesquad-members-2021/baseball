//
//  ViewController.swift
//  baseball-game
//
//  Created by Song on 2021/05/03.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var sboTableView: UITableView!
    
    private let segueId = "selectPitcher"
    private let cellId = "sboCell"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.sboTableView.dataSource = self
    }

    @IBAction func pitcherChangeTouched(_ sender: Any) {
        performSegue(withIdentifier: segueId, sender: nil)
    }
    
}

//임시 코드
extension ViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: cellId) else { return UITableViewCell()}
        
        return cell
    }

}
