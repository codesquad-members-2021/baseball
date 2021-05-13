//
//  GamePlayViewController.swift
//  Baseball
//
//  Created by Jun Ho JANG on 2021/05/06.
//

import UIKit
import Combine

class GamePlayViewController: UIViewController {
    
    @IBOutlet weak var groundView: GroundView!
    @IBOutlet weak var pitchHistoryTableView: UITableView!
    @IBOutlet weak var pitcherView: UIView!

    //                                    홈   1루   2루  3루
    private var runners: [RunnerView?] = [nil, nil, nil, nil]
    private var animator: UIViewPropertyAnimator?
    private var basePoint: [CGPoint]?
    private var viewModel: GamePlayViewModel!
    private var subscriptions = Set<AnyCancellable>()
    
    static let storyboardName = "Main"
    static let storyboardID = "GamePlayViewController"
    
    static func create(with viewModel: GamePlayViewModel) -> GamePlayViewController {
        let storyboard = UIStoryboard(name: storyboardName, bundle: Bundle.main)
        guard let vc = storyboard.instantiateViewController(identifier: storyboardID) as? GamePlayViewController else {
            return GamePlayViewController()
        }
        vc.viewModel = viewModel
        return vc
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        pitchHistoryTableView.delegate = self
        pitchHistoryTableView.dataSource = self
        configureView()
        setBasePoint()
    }
    
    private func configureView() {
        pitcherView.layer.addBorder([.bottom], color: .systemGray4, thickness: 2)
        pitchHistoryTableView.layer.addBorder([.top], color: .systemGray, thickness: 3)
    }
    
    private func setBasePoint() {
        basePoint = [ CGPoint(x: self.groundView.frame.width / 2, y: self.groundView.frame.height / 2 + 120),
                      CGPoint(x: self.groundView.frame.width / 2 + 120, y: self.groundView.frame.height / 2),
                      CGPoint(x: self.groundView.frame.width / 2, y: self.groundView.frame.height / 2 - 120),
                      CGPoint(x: self.groundView.frame.width / 2 - 120, y: self.groundView.frame.height / 2)
        ]
    }
    
    private func animation(runner: RunnerView) {
        runners[0] = runner
        runners.enumerated().filter {
            $0.element != nil
        }.forEach { base, runner in
            runner?.center = basePoint?[(base+1)%4] ?? CGPoint()
        }
    }
    
    private func movingRunners() {
        for i in stride(from: 3, to: -1, by: -1){
            guard runners[i] != nil else { continue }
            if i == 3 {
                runners[i]?.removeFromSuperview()
                runners[i] = nil
            } else {
                runners[i+1] = runners[i]
                runners[i] = nil
            }
        }
    }
    
}

//MARK: - Action
extension GamePlayViewController {
    @IBAction func pitchButtonTapped(_ sender: Any) {
        let batterView = RunnerView.init(frame: CGRect(origin: groundView.bounds.origin, size: CGSize(width: 24, height: 24)))
        self.groundView.addSubview(batterView)
        batterView.center = basePoint?[0] ?? CGPoint()
        
        animator = UIViewPropertyAnimator.runningPropertyAnimator(withDuration: 1, delay: 0, options: [], animations: {
            self.animation(runner: batterView)
        }, completion: { _ in
            self.movingRunners()
        })
    }
}

extension GamePlayViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        2
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "PitchHistoryCell") as? PitchHistoryCell else {
            return UITableViewCell()
        }
        return cell
    }
    
    
}

extension GamePlayViewController: UITableViewDelegate {
    
}
