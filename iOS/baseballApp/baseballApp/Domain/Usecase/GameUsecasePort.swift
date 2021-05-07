import Foundation
import RxSwift

protocol GameUsecasePort {
    
    @discardableResult
    func appendGame(from data: Game) -> Observable<Game>
    
    @discardableResult
    func gameList() -> Observable<[Game]>
}
