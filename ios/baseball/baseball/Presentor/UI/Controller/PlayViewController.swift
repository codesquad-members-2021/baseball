//
//  PlayViewController.swift
//  baseball
//
//  Created by zombietux on 2021/05/07.
//

import UIKit
import RxSwift
import RxCocoa

class PlayViewController: UIViewController {

    @IBOutlet weak var scoreView: ScoreView!
    @IBOutlet weak var matchBoardView: MatchBoardView!
    @IBOutlet weak var matchUpView: MatchUpView!
    @IBOutlet weak var collectionView: UICollectionView!
    
    private var id: String = "U924AX"
    private var viewModel: PlayViewModel!
    private var disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        viewModel = PlayViewModel(id: id)
        
        viewModel.pitchInfo
            .observe(on: MainScheduler.instance)
            .bind(to: collectionView.rx.items(cellIdentifier: PitchInfoCell.reuseIdentifier, cellType: PitchInfoCell.self)) { index, item, cell in
                cell.configureCell(order: index, pitchInfo: [true, true])
            }
            .disposed(by: disposeBag)
        
        configureScoreView()
        configureInnginInfoLabel()
        configureMatchUpInfoView()
        configureSBOBoardView()
    }
    
    func initId(_ id: String) {
        self.id = id
    }
    
    private func configureScoreView() {
        self.viewModel.scores
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: {
                self.scoreView.configureScore(score: $0)
            })
            .disposed(by: disposeBag)
    }
    
    private func configureInnginInfoLabel() {
        self.viewModel.inningInfo
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: {
                self.matchBoardView.configureInningInfo(inningInfo: $0)
            })
            .disposed(by: disposeBag)
    }
    
    private func configureMatchUpInfoView() {
        self.viewModel.pitcher
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: {
                self.matchUpView.configurePitcherMatchUpView($0)
            })
            .disposed(by: disposeBag)
        
        self.viewModel.batter
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: {
                self.matchUpView.configureBatterMatchUpView($0)
            })
            .disposed(by: disposeBag)
    }
    
    private func configureSBOBoardView() {
        self.viewModel.sbo
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: {
                self.matchBoardView.configureSBOBoardView(sbo: $0)
            })
            .disposed(by: disposeBag)
    }
}
