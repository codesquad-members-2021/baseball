//
//  ProBaseballTests.swift
//  ProBaseballTests
//
//  Created by 조중윤 on 2021/05/03.
//

import XCTest
@testable import ProBaseball

class ProBaseballTests: XCTestCase {
    
    override func setUp() {
    }
    
    override func tearDown() {
    }

    func test_network_controller() {
        let networkController = NetworkController()
        let endpoint = Endpoint(path: "/test")
        print(endpoint.url)
        
        XCTAssertNotNil(networkController.get(type: GameList.self, url: endpoint.url, headers: endpoint.headers))
    }
}
