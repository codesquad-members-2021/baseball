import Foundation
import RxSwift
import RxCocoa

class GameViewModel: CommonViewModel {
    private var disposeBag = DisposeBag()
    var games: Observable<[Game]> {
        return gameUsecase.gameList()
    }
    
    func saveGame(game: Game) {
        self.gameUsecase.appendGame(from: game)
    }
    
    func getGameInfo() {
        try? API.shared.requestGames()
            .subscribe { gameData in
                self.transformDTO(to: gameData) { game in
                    self.saveGame(game: game)
                }
            } onError: { error in
                print(error.localizedDescription)
            }.disposed(by: disposeBag)
    }
    
    private func transformDTO(to game: GameDTO, completion: @escaping (Game)->Void
    ){
        game.body.forEach { data in
            completion(data)
        }
    }
}
