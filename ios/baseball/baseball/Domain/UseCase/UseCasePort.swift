//
//  UseCasePort.swift
//  baseball
//
//  Created by zombietux on 2021/05/11.
//

import Foundation
import RxSwift

protocol UseCasePort {
    func get<T: Codable>(path: APIPath, id: String?) -> Observable<T>
}

protocol ListUseCasePort {
    func get<T: Codable>(path: APIPath, id: String?) -> Observable<[T]>
}
