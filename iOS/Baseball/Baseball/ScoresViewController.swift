//
//  ScoresViewController.swift
//  Baseball
//
//  Created by 심영민 on 2021/05/06.
//

import UIKit

class ScoresViewController: UIViewController {

    @IBOutlet weak var inningStackView: UIStackView!
    @IBOutlet weak var awayStackView: UIStackView!
    @IBOutlet weak var homeStackView: UIStackView!
    @IBOutlet var inningLabel: [UILabel]!
    @IBOutlet var homeScoreLabel: [UILabel]!
    @IBOutlet var awayScoreLabel: [UILabel]!
    
    
    @IBOutlet weak var view1: UIView!
    @IBOutlet weak var view2: UIView!
    @IBOutlet weak var view3: UIView!
    
    @IBOutlet var labels1: [UILabel]!
    @IBOutlet var labels2: [UILabel]!
    @IBOutlet var labels3: [UILabel]!
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configure()
        configureHomeScore()
        configureAwayScore()
    }
    
    func configure() {
        var xPos = 0
        for i in 1..<12 {
            let label = UILabel()
            label.text = "\(i)"
            inningLabel.append(label)
            inningStackView.addArrangedSubview(label)
        }
    }
    
    func configureHomeScore() {
        awayScoreLabel[0].text = "Captin"
        for i in 1..<12 {
            let label = UILabel()
            label.text = "\(i)"
            awayScoreLabel.append(label)
            awayStackView.addArrangedSubview(label)
        }
    }
    
    func configureAwayScore() {
        homeScoreLabel[0].text = "Rockets"
        for i in 20..<31 {
            let label = UILabel()
            label.text = "\(i)"
            homeScoreLabel.append(label)
            homeStackView.addArrangedSubview(label)
        }
    }
}
