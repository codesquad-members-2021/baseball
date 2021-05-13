import UIKit
import RxSwift

class ScoreViewController: UIViewController {
        
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

