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
        gameUsecase.getGameInfo().subscribe { gameData in
//            dump(gameData)
            gameData.body.forEach { game in
                self.saveGame(game: game)
            }
        } onError: { error in
            print(error.localizedDescription)
        }.disposed(by: disposeBag)
    }
}
