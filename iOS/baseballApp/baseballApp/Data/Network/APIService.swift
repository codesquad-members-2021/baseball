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
    

    func requestPlay(gameID: Int, inningID: Int) throws -> Observable<PlayDTO> {
        guard  let url = Endpoint.getGames(path: "baseball/\(gameID)/inning/\(inningID)") else {

    func requestScore() throws -> Observable<ScoreDTO> {
        guard let url = URL(string: "https://791e125f-f50f-4801-90d3-3b106e723a88.mock.pstmn.io/baseball/1/score") else {

            throw APIError.urlNotSupport
        }
        return getAndDecode(url)
    }

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
