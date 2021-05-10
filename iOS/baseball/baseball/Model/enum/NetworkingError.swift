//
//  NetworkingError.swift
//  baseball
//
//  Created by Issac on 2021/05/06.
//

import Foundation

enum NetworkingError: String, Error {
    case networkError = "Network error가 발생했습니다."
    case responseError = "URLSession 요청이 받아들여지지 않았습니다."
    case decodeError = "JSON decode가 잘못됐습니다."
    case encodeError = "JSON encode가 잘못됐습니다."
    case ASWebAuthenticationSessionError = "사용자 인증 과정에서 오류가 발생했습니다."
    case notConnectedToInternet = "인터넷에 연결되어 있지 않습니다."
}
