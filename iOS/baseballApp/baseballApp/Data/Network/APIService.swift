import Foundation
import RxSwift
import Alamofire

class APIService {
    static let shared: APIService = APIService()

    func requestGames() throws -> Observable<GameDTO> {
        guard  let url = Endpoint.getGames(path: "baseball") else {
            throw APIError.urlNotSupport
        }
        return getAndDecode(url)
    }
    
//    func checkGameStatus() throws -> Observable<Game> {
//        guard let url = URL(string: Endpoint.postGame) else {
//            throw APIError.urlNotSupport
//        }
//        return get(url)
//    }
    
    private func getAndDecode<T: Codable>(_ url: URL) -> Observable<T> {
        return Observable.create { observer in
            AF.request(url, method: .get)
                .responseDecodable(of: T.self) { response in
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

enum APIError: LocalizedError {
    case urlNotSupport
    case noData
    
    var errorDescription: String? {
        switch self {
        case .urlNotSupport: return "URL NOT Supported"
        case .noData: return "Has No Data"
        }
    }
}
