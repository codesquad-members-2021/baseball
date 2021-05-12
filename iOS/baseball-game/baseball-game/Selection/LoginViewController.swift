//
//  LoginViewController.swift
//  baseball-game
//
//  Created by Lia on 2021/05/06.
//

import UIKit



class LoginViewController: UIViewController {
    
    static let storyboard = "Main"
        
    @IBOutlet weak var IDTextField: UITextField!
    
    @IBAction func okButtonTouched(_ sender: UIButton) {
        let nextVC = ControllerFactory.instantiate(viewController: SelectionViewController.self) as! SelectionViewController
        let gameInfo = GameInfo(userID: IDTextField.text ?? "", team: "")
        
        nextVC.viewModel.setModel(with: gameInfo)
        self.navigationController?.pushViewController(nextVC, animated: false)
    }
    
}


extension LoginViewController: Instantiatable, IdentifierReusable {
    
    static func instantiate() -> UIViewController {
        let myViewController = UIStoryboard(name: self.storyboard, bundle: nil).instantiateViewController(withIdentifier: self.reuseIdentifier) as? LoginViewController
        
        return myViewController ?? LoginViewController()
    }
    
}
