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
        self.networkManager.requestbaseballGame(url: URLManager.get(url: .gameList), httpMethod: .get) { result in
            print(result)
        }
        playOpacityAnimation()
        playMoveAnimation()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    func moveToGameView() {
        self.performSegue(withIdentifier: "toInGame", sender: nil)
    }
    
    private func playOpacityAnimation() -> Void {
            let layerWidth = view.bounds.size.width / 4
            let myCalayer : CALayer = {
                let calayer = CALayer()
                calayer.bounds = CGRect(x: 0, y: 0, width: layerWidth, height: layerWidth)
                calayer.position = CGPoint(x: view.bounds.size.width / 2 , y: layerWidth)
                calayer.backgroundColor = UIColor.black.cgColor
                return calayer
            }()
            view.layer.addSublayer(myCalayer)
            let animation: CABasicAnimation = CABasicAnimation(keyPath: "opacity")
            animation.fromValue = 1
            animation.toValue = 0
            animation.duration = 1
            animation.repeatCount = 10 //
            myCalayer.add(animation, forKey: "GoRed")
            myCalayer.opacity = 0
        }
        
    private func playMoveAnimation() -> Void {
        
        let layerWidth = view.bounds.size.width / 4
        let myCalayer : CALayer = {
            let calayer = CALayer()
            calayer.bounds = CGRect(x: 0, y: 0, width: layerWidth, height: layerWidth)
            calayer.position = CGPoint(x: view.bounds.size.width / 2 , y: layerWidth)
            calayer.backgroundColor = UIColor.black.cgColor
            return calayer
        }()
        view.layer.addSublayer(myCalayer)
        let animation: CABasicAnimation = CABasicAnimation(keyPath: "position")
        animation.fromValue = myCalayer.position
        animation.toValue = CGPoint(x: myCalayer.position.x, y: view.bounds.size.height - view.bounds.size.width / 4)
        animation.duration = 1
        myCalayer.add(animation, forKey: "move down")
//        myCalayer.position = CGPoint(x: myCalayer.position.x, y: view.bounds.size.height - view.bounds.size.width / 4)
    }
}

