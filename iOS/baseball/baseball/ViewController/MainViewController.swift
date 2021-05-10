//
//  MainViewController.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import UIKit

final class MainViewController: UIViewController {
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
