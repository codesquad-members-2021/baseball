import Foundation

class CommonViewModel {
    let gameUsecase: GameUsecasePort
    
    init() {
        gameUsecase = GameUsecase()
    }
}
