import Foundation
import RxSwift

protocol GameViewModelType {
    func saveGame(from data: Game)
    
    @discardableResult
    func getGames() -> Observable<[Game]>
}
