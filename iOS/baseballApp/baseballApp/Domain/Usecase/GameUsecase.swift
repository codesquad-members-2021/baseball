import Foundation
import RxSwift

class GameUsecase: GameUsecasePort {
    private var games = [Game]()
    
    private lazy var gameStorage = BehaviorSubject<[Game]>(value: games)
    private var disposeBag = DisposeBag()
    func appendGame(from data: Game) -> Observable<Game> {
        games.append(data)
        gameStorage.onNext(games)
        return Observable.just(data)
    }
    
    func gameList() -> Observable<[Game]> {
        return gameStorage
    }
    
    let api = API.shared
    func getGameInfo() -> Observable<GameDTO> {
        return Observable.create { observer in
            self.api.requestGames()
                .subscribe(onNext: { gameDTO in
                    observer.onNext(gameDTO)
                }, onError: { error in
                    print(error.localizedDescription)})
                .disposed(by: self.disposeBag)
            return Disposables.create()
        }
    }
    
    
}
