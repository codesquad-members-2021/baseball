import Foundation

class CommonViewModel {
    let gameUsecase: UsecasePort
    
    init() {
        gameUsecase = GameUsecase()
    }
}
