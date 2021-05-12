import UIKit

class ScoreViewController: UIViewController {
        
    @IBOutlet var homeTeamScores: [UILabel]!
    @IBOutlet var awayTeamScores: [UILabel]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // 추후 API형태에 따라 해당 메서드를 알맞게 수정 필요
    func setupScores(_ team: Int, _ inning: Int, _ score: Int) {
        if team == 0 {
            setupInningScore(homeTeamScores[inning], score)
        } else {
            setupInningScore(awayTeamScores[inning], score)
        }
    }
    
}

private extension ScoreViewController {
    private func setupInningScore(_ inning: UILabel, _ score: Int) {
        inning.textColor = UIColor.black
        inning.text = "\(score)"
    }
    
    private func setupTotalScore(team: [UILabel]) -> Int {
        var total = 0
        for i in 0..<team.count {
            total = Int(team[i].text!)!
        }
        return total
    }
}
