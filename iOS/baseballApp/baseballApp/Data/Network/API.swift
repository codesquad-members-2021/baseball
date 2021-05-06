import Foundation
import RxSwift
import Alamofire

class API {
    static let shared: API = API()

    func requestGames(from url: URL) -> Observable<GameDTO> {
        return get(url)
    }
    
    func get<T: Codable>(_ url: URL) -> Observable<T> {
        return Observable.create { observer in
            AF.request(url, method: .get)
                .responseDecodable(of: T.self, queue: DispatchQueue.global()) { response in
                    switch response.result {
                    case .failure(let error):
                        observer.onError(error)
                    case .success(let data):
                        observer.onNext(data)
                        observer.onCompleted()
                    }
                    
                }
            return Disposables.create()
        }
    }
    
}
