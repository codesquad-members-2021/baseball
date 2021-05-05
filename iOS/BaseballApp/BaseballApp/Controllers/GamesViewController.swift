//
//  ViewController.swift
//  BaseballApp
//
//  Created by Ador on 2021/05/04.
//

import UIKit
import Combine

class GamesViewController: UIViewController {

    @IBOutlet weak var gamesTableView: UITableView!
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
                self?.gamesTableView.reloadData()
            })
            .store(in: &self.cancelBag)
    }
}

