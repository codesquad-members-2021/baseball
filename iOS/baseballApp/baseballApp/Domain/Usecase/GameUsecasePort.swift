import Foundation
import RxSwift

protocol GameUsecasePort {
    func getGameInfo() -> Observable<GameDTO>
    
    @discardableResult
    func appendGame(from data: Game) -> Observable<Game>
    
    @discardableResult
    func gameList() -> Observable<[Game]>
}
