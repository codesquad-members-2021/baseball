import UIKit
import RxSwift

class ScoreViewController: UIViewController {
        
    @IBOutlet weak var awayTeamName: UILabel!
    @IBOutlet weak var awayTotalScore: UILabel!
    @IBOutlet weak var homeTotalScore: UILabel!
    @IBOutlet weak var homeTeamName: UILabel!
    @IBOutlet weak var teamSegment: UISegmentedControl!
    @IBOutlet weak var scoreTableView: UITableView!
    @IBOutlet var homeTeamScores: [UILabel]!
    @IBOutlet var awayTeamScores: [UILabel]!
    
    private let disposeBag = DisposeBag()
    private var viewModel = ScoreViewModel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bindViewModel()
        setupSegmentControll()
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
        
        viewModel.getHomePlayerInfo()
            .bind(to: scoreTableView.rx.items(cellIdentifier: ScoreCell.identifier, cellType: ScoreCell.self)) { _, player, cell in
                cell.configure(player)
            }.disposed(by: disposeBag)
    }
}

private extension ScoreViewController {
    
    private func setupHomeScore(_ scoreInfo:TeamScore) {
        homeTeamName.text = scoreInfo.teamName
        setupScore(homeTeamScores, scoreInfo.teamScore)
        let total = setupTotalScore(homeTeamScores, scoreInfo.teamScore)
        homeTotalScore.text = "\(total)"
    }
    
    private func setupAwayScore(_ scoreInfo:TeamScore) {
        awayTeamName.text = scoreInfo.teamName
        setupScore(awayTeamScores, scoreInfo.teamScore)
        let total = setupTotalScore(awayTeamScores, scoreInfo.teamScore)
        awayTotalScore.text = "\(total)"
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
    
    private func setupTotalScore(_ team: [UILabel], _ scores:[Int]) -> Int {
        var total = 0
        for score in scores {
            total += score
        }
        team[team.endIndex-1].text = "\(total)"
        return total
    }
    
    private func setupSegmentControll() {
        teamSegment.addTarget(self, action: #selector(segmentChanged(seg:)), for: UIControl.Event.valueChanged)
    }
    
    @objc private func segmentChanged(seg: UISegmentedControl) {
        switch seg.selectedSegmentIndex {
        case 0:
            scoreTableView.delegate = nil
            scoreTableView.dataSource = nil
            viewModel.getHomePlayerInfo()
                .bind(to: scoreTableView.rx.items(cellIdentifier: ScoreCell.identifier, cellType: ScoreCell.self)) { _, player, cell in
                    cell.configure(player)
                }.disposed(by: disposeBag)
        case 1:
            scoreTableView.delegate = nil
            scoreTableView.dataSource = nil
            viewModel.getAwayPlayerInfo()
                .bind(to: scoreTableView.rx.items(cellIdentifier: ScoreCell.identifier, cellType: ScoreCell.self)) { _, player, cell in
                    cell.configure(player)
                }.disposed(by: disposeBag)
        default:
            break
        }
        
    }
}

