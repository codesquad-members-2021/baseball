import Foundation
import RxSwift
import RxCocoa

class ScoreViewModel {
    private var scores = [ScoreDTO]()
    private lazy var scoreStorage = BehaviorSubject<[ScoreDTO]>(value: scores)
    private var homePlayers = [PlayerInfo]()
    private lazy var homePlayerStorage = BehaviorSubject<[PlayerInfo]>(value: homePlayers)
    private var awayPlayers = [PlayerInfo]()
    private lazy var awayPlayerStorage = BehaviorSubject<[PlayerInfo]>(value: awayPlayers)
    private var disposeBag = DisposeBag()
    
    func saveScore(from data: ScoreDTO) {
        scores.append(data)
        scoreStorage.onNext(scores)
    }
    
    func saveHomePlayer(from data: PlayerInfo) {
        homePlayers.append(data)
        homePlayerStorage.onNext(homePlayers)
    }
    
    func saveAwayPlayer(from data: PlayerInfo) {
        awayPlayers.append(data)
        awayPlayerStorage.onNext(awayPlayers)
    }
    
    func getScore() -> Observable<[ScoreDTO]> {
        return scoreStorage
    }
    
    func getHomePlayerInfo() -> Observable<[PlayerInfo]> {
        return homePlayerStorage
    }
    
    func getAwayPlayerInfo() -> Observable<[PlayerInfo]> {
        return awayPlayerStorage
    }
    
    func getScoreInfo() {
        try? APIService.shared.requestScore()
            .subscribe(onNext: { scoreData in
                self.saveScore(from: scoreData)
                scoreData.homeTeam.players.forEach { player in
                    self.saveHomePlayer(from: player)
                }
                scoreData.awayTeam.players.forEach { player in
                    self.saveAwayPlayer(from: player)
                }
            }, onError: { error in
                print(error.localizedDescription)
            }).disposed(by: disposeBag)
    }
}
