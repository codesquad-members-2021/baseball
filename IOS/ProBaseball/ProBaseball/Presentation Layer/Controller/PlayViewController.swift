//
//  PlayViewController.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import UIKit

enum BallCountSection: CaseIterable {
    case main
}

class PlayViewController: UIViewController {
    @IBOutlet weak var currentPitcher: UILabel!
    @IBOutlet weak var currentBatter: UILabel!
    @IBOutlet weak var currentPitcherNum: UILabel!
    @IBOutlet weak var strikeStackView: UIStackView!
    @IBOutlet weak var ballStackView: UIStackView!
    @IBOutlet weak var outStackView: UIStackView!
    @IBOutlet weak var currentBatterDescription: UILabel!
    @IBOutlet weak var inningLabel: UILabel!
    @IBOutlet weak var offenseOrDefense: UILabel!
    @IBOutlet weak var ballCountCollectionView: UICollectionView!
    lazy var dataSource = configureDataSource()
    var viewModel: PlayViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.ballCountCollectionView.backgroundColor = .red
        ballCountCollectionView.register(UINib(nibName: "BallCountCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "BallCountCollectionViewCell")
        ballCountCollectionView.dataSource = dataSource
        ballCountCollectionView.delegate = self
        bind()
    }
    
    func depend(viewModel: PlayViewModel) {
        self.viewModel = viewModel
    }
    
    func bind() {
        viewModel.fetchGame()
        viewModel.didUpdateGame { [weak self] (game) in
            self?.updateSnapshot(with: game)
            //현재타자
            if game.myTeam.isAttack == true {
                self?.currentBatter.text = game.myTeam.currentBatsman.name
            }
            
            //현재투수
            self?.currentPitcher.text = game.myTeam.currentPitcher.name
            //투수등판번호
            self?.currentPitcherNum.text = ""
            //1타석 0안타
            self?.currentBatterDescription.text = ""
            
            self?.strikeStackView.addSubview(UIView())
            self?.ballStackView.addSubview(UIView())
            self?.outStackView.addSubview(UIView())
            
            //2회초
            self?.inningLabel.text = ""
            //공격 또는 수비
            self?.offenseOrDefense.text = ""
        }
    }
    
    func configureDataSource() -> UICollectionViewDiffableDataSource<BallCountSection, Game> {
        let dataSource = UICollectionViewDiffableDataSource<BallCountSection, Game>(collectionView: ballCountCollectionView) { (collectionView, indexPath, game) -> UICollectionViewCell? in
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "BallCountCollectionViewCell", for: indexPath) as! BallCountCollectionViewCell
            cell.ballState.text = "스트라이크"
            cell.cellCount.setTitle(String(indexPath.row), for: .normal)
            cell.ballStateHistoryNum.text = "\(game.ballCount.strike)-\(game.ballCount.ball)"
            return cell
        }
        return dataSource
    }
    
    func updateSnapshot(with: Game) {
        var snapshot = NSDiffableDataSourceSnapshot<BallCountSection, Game>()
        snapshot.appendSections(BallCountSection.allCases)
        snapshot.appendItems([with], toSection: BallCountSection.main)
       
        dataSource.apply(snapshot)
    }
}

extension PlayViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: self.ballCountCollectionView.frame.width, height: self.ballCountCollectionView.frame.height / 6)
    }
}
