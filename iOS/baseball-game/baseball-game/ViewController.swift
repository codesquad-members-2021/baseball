//
//  ViewController.swift
//  baseball-game
//
//  Created by Song on 2021/05/03.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var sboTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.sboTableView.dataSource = self
    }


}

extension ViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "sboCell") else { return UITableViewCell()}
        
        return cell
    }

}
