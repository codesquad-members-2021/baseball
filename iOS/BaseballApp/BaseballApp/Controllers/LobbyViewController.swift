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
    var viewModel: RoomsViewModel?
    var cancelBag = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        viewModel = RoomsViewModel()
        bind()
    }
    
    func bind() {
        viewModel?.$rooms
            .receive(on: DispatchQueue.main)
            .sink(receiveValue: { [weak self] _ in
                self?.roomsTableView.reloadData()
            })
            .store(in: &self.cancelBag)
    }
}

