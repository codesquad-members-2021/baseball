//
//  ViewController.swift
//  baseball
//
//  Created by 박정하 on 2021/05/03.
//

import UIKit

class GameSelectViewController: UIViewController, GameSelectViewControllerManageable{
  
    @IBOutlet weak var matchupCell: MatchUpCell!
    private let networkManager: NetworkManager
    
    override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        self.networkManager = NetworkManager()
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        self.networkManager = NetworkManager()
        super.init(coder: coder)
    }
    
    override func loadView() {
        super.loadView()
        self.matchupCell.set(delegate: self)
        self.networkManager.requestbaseballGame(url: .gameList, httpMethod: .get) { result in
            print(result)
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    func moveToGameView() {
        self.performSegue(withIdentifier: "toInGame", sender: nil)
    }
}

