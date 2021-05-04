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
    func get<T: Codable>() -> Observable<T> {
        return Observable<T>.create({ observer in
            let endPoint = EndPoint.init(method: .get, path: .test)
            
            var request : URLRequest {
                var request = URLRequest.init(url: URL(string: "")!)
                do {
                    request = try endPoint.asURLRequest()
                } catch {
                    assertionFailure("NetworkService.get.request")
                }
                return request
            }
            
            let dataRequest = AF.request(request)
            
            dataRequest.responseData { response in
                switch response.result {
                case .success(let data):
                    do {
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
