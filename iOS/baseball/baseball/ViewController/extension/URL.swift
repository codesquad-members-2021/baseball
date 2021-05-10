//
//  URL.swift
//  baseball
//
//  Created by Issac on 2021/05/04.
//

import Foundation

extension URL {
    func appending(_ queryItems: [URLQueryItem]) -> URL? {
        guard var urlComponents = URLComponents(url: self, resolvingAgainstBaseURL: true) else {
            return nil
        }

        urlComponents.queryItems = (urlComponents.queryItems ?? []) + queryItems
        return urlComponents.url
    }
    
    func extractCallbackURLCode() -> String {
        guard let callBackURLCode = self.absoluteString.split(separator: "=").last else {
            return ""
        }
        return String(callBackURLCode)
    }
}
