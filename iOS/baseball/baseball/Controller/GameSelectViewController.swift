//
//  ViewController.swift
//  baseball
//
//  Created by 박정하 on 2021/05/03.
//

import UIKit

class GameSelectViewController: UIViewController, GameSelectViewControllerManageable{
  
    @IBOutlet weak var matchupCell: MatchUpCell!
    
    override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        //self.matchupCell.set(delegate: self)
    }
    
    override func loadView() {
        super.loadView()
        self.matchupCell.set(delegate: self)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    func moveToGameView() {
        self.performSegue(withIdentifier: "toInGame", sender: nil)
    }
}

