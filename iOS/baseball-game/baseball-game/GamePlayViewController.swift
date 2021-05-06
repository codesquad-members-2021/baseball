//
//  ViewController.swift
//  baseball-game
//
//  Created by Song on 2021/05/03.
//

import UIKit
import Combine

class GamePlayViewController: UIViewController {

    @IBOutlet weak var pitchListTableView: UITableView!
    @IBOutlet weak var pitchButton: UIButton!

    enum ViewID {
        static let segue = "selectPitcher"
        static let cell = "pitchListCell"
    }
    
    enum Role {
        static let offense = "offense"
        static let defense = "defense"
    }

    private var gameManager: GameManager?

    private let isHome = true // 게임 선택 시 값을 지정해줄 수 있도록 한다 (prepare segue?)
    private var cancelBag = Set<AnyCancellable>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.pitchButton.isHidden = true
        self.pitchListTableView.dataSource = self
        
        configureGame()
    }
    
    private func configureGame() {
        //viewModel이나 유즈케이스 분리가 필요하다.
        NetworkManager.request(type: GameManager.self, url: EndPoint.url(path: "/1/attack")!)
            .sink { error in
            print(error)
        } receiveValue: { game in
            self.gameManager = game
            DispatchQueue.main.async {
                self.pitchListTableView.reloadData()
                self.updateLabels()
            }
        }.store(in: &cancelBag)
    }

    @IBAction func pitcherChangeTouched(_ sender: Any) {
        performSegue(withIdentifier: ViewID.segue, sender: nil)
    }
    
    //정리가 필요하다.
    @IBOutlet weak var homeLabel: UILabel!
    @IBOutlet weak var homeScoreLabel: UILabel!
    
    @IBOutlet weak var awayLabel: UILabel!
    @IBOutlet weak var awayScoreLabel: UILabel!
    
    @IBOutlet weak var inningLabel: UILabel!
    @IBOutlet weak var turnLabel: UILabel!
    
    @IBOutlet weak var pitcherView: UIView!
    @IBOutlet weak var pitcherNameLabel: UILabel!
    @IBOutlet weak var pitherInfoLabel: UILabel!
    
    @IBOutlet weak var batterView: UIView!
    @IBOutlet weak var batterNameLabel: UILabel!
    @IBOutlet weak var batterInfoLabel: UILabel!
    
    
    private func updateLabels() {
        guard let game = gameManager?.game else { return }
        let homeInfo = game.home
        homeLabel.text = homeInfo.name
        homeScoreLabel.text = "\(homeInfo.score)"
        
        let awayInfo = game.away
        awayLabel.text = awayInfo.name
        awayScoreLabel.text = "\(awayInfo.score)"
        
        let inningInfos = game.inning
        let topOrBottom = inningInfos[1] == 1 ? "초" : "말"
        inningLabel.text = "\(inningInfos[0])회 \(topOrBottom)"
        
        let pitcherInfo = homeInfo.role == Role.defense ? homeInfo.player : awayInfo.player
        
        let batterInfo = homeInfo.role == Role.offense ? homeInfo.player : awayInfo.player
        
        pitcherNameLabel.text = pitcherInfo.name
        pitherInfoLabel.text = pitcherInfo.info
        
        batterNameLabel.text = batterInfo.name
        batterInfoLabel.text = batterInfo.info
        
        let myTeamInfo = isHome ? homeInfo : awayInfo
        
        if myTeamInfo.role == Role.defense {
            self.pitchButton.isHidden = false
        }
        
        let boldView = myTeamInfo.role == Role.defense ? pitcherView : batterView
        let normalView = myTeamInfo.role == Role.defense ? batterView : pitcherView
        
        boldView?.backgroundColor = .lightGray
        normalView?.backgroundColor = .white
    }
}

//임시 코드
extension GamePlayViewController: UITableViewDataSource {

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if let game = gameManager?.game {
            return game.pitches.count
        } else {
            return 0
        }
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {

        guard let game = gameManager?.game,
              let cell = tableView.dequeueReusableCell(withIdentifier: ViewID.cell) as? PitchListTableViewCell else {
            return PitchListTableViewCell()
        }

        let index = indexPath.row
        let totalCount = game.pitches.count
        let cellInfo = game.pitches[index]
        
        cell.updateLabels(count: totalCount - index, result: cellInfo.result, log: cellInfo.log)
        
        return cell
    }

}
