//
//  NetworkService.swift
//  baseball
//
//  Created by 이다훈 on 2021/05/04.
//

import Foundation
import RxSwift
import Alamofire

class NetworkService {
    func get<T: Codable>(path: APIPath, id: String? = nil) -> Observable<T> {
        return Observable<T>.create({ observer in
            let endPoint = EndPoint.init(method: .get, path: path, id: id)
            
            var request : URLRequest {
                
                do {
                    let request = try endPoint.asURLRequest()
                    return request
                } catch {
                    assertionFailure("NetworkService.get.request")
                }
                return URLRequest.init(url: URL(string: "")!)
            }
            
            let dataRequest = AF.request(request)
            
            dataRequest.responseData { response in
                switch response.result {
                case .success(let data):
                    do {
                        print(T.self)
                        let model : T = try JSONDecoder().decode(T.self, from: data)
                        observer.onNext(model)
                    } catch  {
                        assertionFailure("NetworkService.get.dataRequest.responseData. case: .success")
                    }
                    
                case .failure(let error):
                    observer.onError(error)
                }
            }
            
            return Disposables.create {
                dataRequest.cancel()
            }
        })
    }
}
