//
//  LoginViewController.swift
//  baseball-game
//
//  Created by Lia on 2021/05/06.
//

import UIKit

class LoginViewController: UIViewController {
    
    @IBOutlet weak var IDTextField: UITextField!
    
    @IBAction func okButtonTouched(_ sender: UIButton) {
        let gameInfo = GameInfo(userID: IDTextField.text ?? "", team: "")
        
        guard let nextVC = storyboard?.instantiateViewController(withIdentifier: "SelectionViewController") as? SelectionViewController else { return }
        nextVC.viewModel.setModel(with: gameInfo)
        self.navigationController?.pushViewController(nextVC, animated: false)
    }
    
}
