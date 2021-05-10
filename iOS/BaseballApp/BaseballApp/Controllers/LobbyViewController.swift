//
//  ViewController.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import UIKit
import Combine

class LobbyViewController: UIViewController {

    @IBOutlet weak var roomsTableView: UITableView!
    var viewModel: RoomsViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        roomsTableView.dataSource = self
        
        viewModel = RoomsViewModel()
        viewModel.load {
            DispatchQueue.main.async {
                self.roomsTableView.reloadData()
            }
        }
    }
   
}

extension LobbyViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return viewModel.rooms.data.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: RoomTableViewCell.identifier, for: indexPath) as? RoomTableViewCell else {
            return UITableViewCell()
        }
        
        let data = viewModel.rooms.data[indexPath.row]
        cell.fill(data: data)
        return cell
    }
}
