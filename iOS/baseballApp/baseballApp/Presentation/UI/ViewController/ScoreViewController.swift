import UIKit
import RxSwift

class ScoreViewController: UIViewController {
        
    @IBOutlet var homeTeamScores: [UILabel]!
    
    @IBOutlet var awayTeamScores: [UILabel]!
    
    private let disposeBag = DisposeBag()
    private var viewModel = ScoreViewModel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bindViewModel()
    }
    
    func bindViewModel() {
        viewModel.getScoreInfo()
        
        viewModel.getScore()
            .subscribe(onNext: { [weak self] data in
                if !data.isEmpty {
                self?.setupHomeScore(data.first!.homeTeam)
                self?.setupAwayScore(data.first!.awayTeam)
                }
            }, onError: { error in
                print(error)
            })
            .disposed(by: disposeBag)
    }
}

private extension ScoreViewController {
    
    private func setupHomeScore(_ scoreInfo:TeamScore) {
        setupScore(homeTeamScores, scoreInfo.teamScore)
        setupTotalScore(homeTeamScores, scoreInfo.teamScore)
    }
    
    private func setupAwayScore(_ scoreInfo:TeamScore) {
        setupScore(awayTeamScores, scoreInfo.teamScore)
        setupTotalScore(awayTeamScores, scoreInfo.teamScore)
    }
    
    private func setupScore(_ team:[UILabel], _ score:[Int]) {
        for i in 0..<score.count {
            setupInningScore(team[i], score[i])
        }
    }
    
    private func setupInningScore(_ inning: UILabel, _ score: Int) {
        inning.textColor = UIColor.black
        inning.text = "\(score)"
    }
    
    private func setupTotalScore(_ team: [UILabel], _ scores:[Int]){
        var total = 0
        for score in scores {
            total += score
        }
        team[team.endIndex-1].text = "\(total)"
    }
}
