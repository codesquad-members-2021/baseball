import Foundation
import RxSwift

protocol GameViewModelType {
    @discardableResult
    func saveGame(from data: Game) -> Observable<Game>
    
    @discardableResult
    func getGames() -> Observable<[Game]>
}
