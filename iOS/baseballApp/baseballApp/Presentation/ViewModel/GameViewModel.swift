import Foundation
import RxSwift
import RxCocoa

class GameViewModel: GameViewModelType {
    private var games = [Game]()
    private lazy var gameStorage = BehaviorSubject<[Game]>(value: games)
    private var disposeBag = DisposeBag()
    
    func saveGame(from data: Game) {
        games.append(data)
        gameStorage.onNext(games)
    }
    
    func getGames() -> Observable<[Game]> {
        return gameStorage
    }

    func getGameInfo() {
        try? APIService.shared.requestGames()
            .subscribe { gameData in
                self.transformDTO(to: gameData) { data in
                    self.saveGame(from: data)
                }
            } onError: { error in
                print(error.localizedDescription)
            }.disposed(by: disposeBag)
    }
    
    private func transformDTO(to game: GameDTO, completion: @escaping (Game)->Void
    ){
        game.games.forEach { data in
            completion(data)
        }
    }
    
    static func formatGameID(id: Int) -> String {
        return "Game \(id)"
    }
}
