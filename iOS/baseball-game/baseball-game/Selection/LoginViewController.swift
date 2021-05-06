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
        let tempGame = Game(id: -1, home: Team(team: "", status: ""), away: Team(team: "", status: ""))
        let gameInfo = Info(userID: IDTextField.text ?? "", game: tempGame)
        
        guard let nextVC = storyboard?.instantiateViewController(withIdentifier: "SelectionViewController") as? SelectionViewController else { return }
        nextVC.gameInfo = gameInfo
        self.navigationController?.pushViewController(nextVC, animated: false)
    }
    
}
