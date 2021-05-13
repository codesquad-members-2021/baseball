//
//  GameScoreViewModel.swift
//  Baseball
//
//  Created by 지북 on 2021/05/12.
//

import Foundation
import Combine

class GameScoreViewModel {
    @Published private (set) var homeTeamPlayersRecords: [PlayerRecord]!
    @Published private (set) var awayTeamPlayersRecords: [PlayerRecord]!
    
    private var fetchPlayerRecordsdUseCase: FetchPlayerRecordsUseCase
    
    init(homeTeam: String, awayTeam: String, fetchPlayerRecordsUseCase: FetchPlayerRecordsUseCase) {
        self.fetchPlayerRecordsdUseCase = fetchPlayerRecordsUseCase
        load(homeTeam: homeTeam, awayTeam: awayTeam)
    }
    
    func load(homeTeam:String, awayTeam: String) {
        fetchPlayerRecordsdUseCase.execute(about: homeTeam) { result in
            switch result {
            case .success(let records):
                self.homeTeamPlayersRecords = records
            case .failure(let error):
                print(error.localizedDescription)
                self.errorHandler(error)
            }
        }
        fetchPlayerRecordsdUseCase.execute(about: awayTeam) { result in
            switch result {
            case .success(let records):
                self.awayTeamPlayersRecords = records
            case .failure(let error):
                self.errorHandler(error)
            }
        }
        
    }
    
    func errorHandler(_ error: NetworkError) {
        
    }
}
