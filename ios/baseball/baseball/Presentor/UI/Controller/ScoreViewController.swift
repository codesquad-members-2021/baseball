//
//  ScoreViewController.swift
//  baseball
//
//  Created by zombietux on 2021/05/07.
//

import UIKit
import RxSwift
import RxCocoa

class ScoreViewController: UIViewController {
    
    @IBOutlet weak var collectionView: UICollectionView!
    @IBOutlet weak var scoreView: ScoreView!
    @IBOutlet weak var segmentedControl: UISegmentedControl!
    @IBOutlet weak var homeScoreStack: TeamInningScoreStack!
    @IBOutlet weak var awayScoreStack: TeamInningScoreStack!
    
    private var id: String = "U924AX"
    private var viewModel: ScoreViewModel!
    private var disposeBag = DisposeBag()

    override func viewDidLoad() {
        super.viewDidLoad()
        viewModel = ScoreViewModel(id: id)
        
        configureScoreView()
        configureInningsScoreView()
    }
    
    private func configureInningsScoreView() {
        self.viewModel.inningsScore
            .observe(on: MainScheduler.instance)
            .debug()
            .subscribe(onNext: {
                self.homeScoreStack.addInningViewLabels(inningsScore: $0.home)
            })
            .disposed(by: disposeBag)
        
        self.viewModel.inningsScore
            .observe(on: MainScheduler.instance)
            .debug()
            .subscribe(onNext: {
                self.awayScoreStack.addInningViewLabels(inningsScore: $0.away)
            })
            .disposed(by: disposeBag)
    }
    
    
    private func configureScoreView() {
        self.viewModel.scores
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: {
                self.scoreView.configureScore(score: $0)
            })
            .disposed(by: disposeBag)
    }
}
