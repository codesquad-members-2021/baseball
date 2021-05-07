//
//  MainViewController.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import UIKit

class MainViewController: UIViewController {
    static let identifier = "MainViewController"
    @IBOutlet var teams: [UIButton]!
    var user: UserDTO!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.navigationController?.setNavigationBarHidden(true, animated: false)
    }
}
