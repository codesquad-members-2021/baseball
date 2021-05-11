import Foundation
import RxSwift

protocol UsecasePort {
    
    @discardableResult
    func appendGame(from data: Game) -> Observable<Game>
    
    @discardableResult
    func gameList() -> Observable<[Game]>
}
