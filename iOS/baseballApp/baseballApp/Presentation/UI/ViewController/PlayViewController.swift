import UIKit
import RxSwift

class PlayViewController: UIViewController {
    var game: Game?
    private lazy var ballListData = [String]()
    private var ballCount: BallCount?
    private lazy var ballCountStorage = [BallCount]()
    private lazy var outCount = 0
    private lazy var baseStatus = [Int]()
    
    private lazy var preBaseStatus = [Int]()
//    prePlayerPosition -> StadiumView
    
    @IBOutlet weak var stadiumView: StadiumView!
    @IBOutlet weak var ballCountView: BallCountView!
    @IBOutlet weak var ballListView: UITableView!
    @IBOutlet weak var pitcherNameLabel: UILabel!
    @IBOutlet weak var pitcherBackNumberLabel: UILabel!
    @IBOutlet weak var batterNameLabel: UILabel!
    @IBOutlet weak var batterInfoLabel: UILabel!
    @IBOutlet weak var pitcherCheckMark: UIImageView!
    @IBOutlet weak var batterCheckMark: UIImageView!
    @IBOutlet weak var attackAndDefendLabel: UILabel!
    @IBOutlet weak var inningCountLabel: UILabel!
    @IBOutlet weak var inningPointLabel: UILabel!
    
    @IBAction func pitcherButtonTouched(_ sender: Any) {
        batterCheckMark.isHidden = true
        pitcherCheckMark.isHidden = false
        attackAndDefendLabel.text = "수비"
    }
    @IBAction func batterButtonTouched(_ sender: Any) {
        batterCheckMark.isHidden = false
        pitcherCheckMark.isHidden = true
        attackAndDefendLabel.text = "공격"
    }
    @IBAction func playButtonTouched(_ sender: Any) {
        preBaseStatus = baseStatus // backup
        dump(preBaseStatus)
        ballCountView.initializePosition()
        stadiumView.initializeBase()
        configureUI(gameID: 2, inningID: 22)
//        stadiumView.flag = true
        stadiumView.PreBaseStatus(preBaseStatus)
        stadiumView.setNeedsDisplay()
    }
    
    private let viewModel = PlayViewModel()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        registerXib()
        configureUI(gameID: 1, inningID: 11)
        stadiumView.setNeedsDisplay()
    }
    
    private func registerXib() {
        ballListView.register(UINib(nibName: BallListCell.identifier, bundle: nil), forCellReuseIdentifier: BallListCell.identifier)
    }
//
//    stadiumView.fetch(prePlayerPosition)
    
    func configureUI(gameID: Int, inningID: Int) {
        batterCheckMark.isHidden = false
        pitcherCheckMark.isHidden = true
        attackAndDefendLabel.text = "공격"
        viewModel.getPlayInfo(gameID: gameID, inningID: inningID) { data in
            self.inningCountLabel.text = "\(data.inning)"
            self.inningPointLabel.text = "초"
            self.pitcherNameLabel.text = "\(data.pitcher.name)"
            self.pitcherBackNumberLabel.text = "#\(data.pitcher.backNumber)"
            self.batterNameLabel.text = "\(data.batter.name)"
            self.ballListData = data.ballCount
            self.ballListData.forEach { data in
                let ballCount = BallCount([data])
                if !self.ballCountStorage.isEmpty{ ballCount.update(with: self.ballCountStorage[self.ballCountStorage.endIndex-1])}
                dump(ballCount)
                self.ballCountStorage.append(ballCount)
                dump(self.ballCountStorage)
                
            }
            self.outCount = data.outCount
            self.ballCount = BallCount(data.ballCount)
            
            self.baseStatus = data.baseStatus
            
            self.ballCountView.configure(
                strikeCount: self.ballCount?.strikeCount ?? 0,
                ballCount: self.ballCount?.ballCount ?? 0,
                outCount: self.outCount)
            self.stadiumView.configure(self.baseStatus)
            self.stadiumView.setNeedsDisplay()
            self.ballCountView.setNeedsDisplay()
            self.ballListView.reloadData()
        }
        ballListView.dataSource = self
    }
}

extension PlayViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return ballListData.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {        
        let cell = tableView.dequeueReusableCell(withIdentifier: BallListCell.identifier, for: indexPath) as! BallListCell
        dump(ballListData)
        let index = ballListData.count - indexPath.row - 1
        let ball = ballListData[index]
//        ballCountStorage.update(with: ballListData[indexPath.row])
        dump(ballCountStorage)
        cell.configure(id: index + 1, ball: ball, with: ballCountStorage.popLast()!)
        return cell
    }
}
