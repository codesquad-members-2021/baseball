import Foundation
import RxSwift
import RxCocoa

class ScoreViewModel {
    private var scores = [ScoreDTO]()
    private lazy var scoreStorage = BehaviorSubject<[ScoreDTO]>(value: scores)
    private var disposeBag = DisposeBag()
    
    func saveScore(from data: ScoreDTO) {
        scores.append(data)
        scoreStorage.onNext(scores)
    }
    
    func getScore() -> Observable<[ScoreDTO]> {
        return scoreStorage
    }

    func getScoreInfo() {
        try? APIService.shared.requestScore()
            .subscribe(onNext: { scoreData in
                self.saveScore(from: scoreData)
            }, onError: { error in
                print(error.localizedDescription)
            }).disposed(by: disposeBag)
    }
}
