import Foundation
import RxSwift
import Alamofire

class APIService {
    static let shared: APIService = APIService()
    
    func requestGames() throws -> Observable<GameDTO> {
//        guard  let url = Endpoint.getGames(path: "baseball") else {
        guard let url = URL(string:"http://52.79.138.172:8080/baseball") else {
            throw APIError.urlNotSupport
        }
        return getAndDecode(url)
    }
    
    
    func requestPlay(gameID: Int, inningID: Int) throws -> Observable<PlayDTO> {
        guard  let url = Endpoint.getGames(path: "baseball/\(gameID)/inning/\(inningID)") else { throw APIError.urlNotSupport }
        return getAndDecode(url)
    }
    
//    func requestPitch() throws -> Observable<PlayDTO> {
//        guard  let url = Endpoint.getGames(path: "baseball/pitch") else { throw APIError.urlNotSupport }
//        return getAndDecode(url)
//    }

    
    func requestScore() throws -> Observable<ScoreDTO> {
        guard let url = URL(string: "https://f0eb7133-38c6-4f20-96a2-4a438fe100c8.mock.pstmn.io/baseball/1/score/3"
) else {
            throw APIError.urlNotSupport
        }
        return getAndDecode(url)
    }
    
    
    
    private func getAndDecode<T: Codable>(_ url: URL) -> Observable<T> {
        return Observable.create { observer in
            AF.request(url, method: .get)
                .responseDecodable(of: T.self) { response in
                    dump(response)
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
