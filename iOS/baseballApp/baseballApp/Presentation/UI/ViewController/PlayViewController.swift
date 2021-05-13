import UIKit
import RxSwift

class PlayViewController: UIViewController {
    var game: Game?
    private lazy var ballListData = [String]()
    private lazy var ballCount = BallCount() // Ball + Strike
    private lazy var outCount = 0
    
    @IBOutlet weak var stadiumView: StadiumView!
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
 
    private let viewModel = PlayViewModel()
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        registerXib()
        configureUI()
    }
    
    private func registerXib() {
        ballListView.register(UINib(nibName: BallListCell.identifier, bundle: nil), forCellReuseIdentifier: BallListCell.identifier)
    }
    
    func configureUI() {
        batterCheckMark.isHidden = false
        pitcherCheckMark.isHidden = true
        attackAndDefendLabel.text = "공격"
        viewModel.getPlayInfo(gameID: game!.id, inningID: game!.inningID) { data in
            self.inningCountLabel.text = "\(data.inning)"
            self.inningPointLabel.text = "초"
            self.pitcherNameLabel.text = "\(data.pitcher.name)"
            self.pitcherBackNumberLabel.text = "#\(data.pitcher.backNumber)"
            self.batterNameLabel.text = "\(data.batter.name)"
            self.ballListData = data.ballCount
            
            self.ballListView.reloadData()
            self.ballListView.transform = CGAffineTransform(scaleX: 1, y: -1)
//            self.ballListView.scrollToRow(at: NSIndexPath(item: self.ballListData.count - 1, section: 0) as IndexPath, at: .bottom, animated: true)
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
//        let index = ballListData.count - indexPath.row - 1
        let index = indexPath.row
        let ball = ballListData[index]
        cell.configure(id: index, ball: ball, with: ballCount)
        return cell
    }
}
