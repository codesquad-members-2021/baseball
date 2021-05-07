//
//  ScoreViewController.swift
//  baseball
//
//  Created by 박정하 on 2021/05/04.
//

import UIKit

class ScoreViewController: UIViewController {
    @IBOutlet weak var homeScore: UIStackView!
    @IBOutlet weak var awayScore: UIStackView!
    @IBOutlet weak var customLabel: UILabel!
    
    private var tempInt: Int = 0 //뷰가 추가되는 효과를 보기 위한 임시 변수
    
    func isAttack(myTeam: MyTeam) -> Bool {
        return myTeam.Value == InningInfo().attackTeam
    }
}
