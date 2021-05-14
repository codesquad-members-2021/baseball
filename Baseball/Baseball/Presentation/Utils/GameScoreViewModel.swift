//
//  GameScoreViewModel.swift
//  Baseball
//
//  Created by 지북 on 2021/05/12.
//

import Foundation
import Combine

class GameScoreViewModel {
    @Published private (set) var error: String
    @Published private (set) var selectedPlayerTeam: [PlayerRecord]!
    
    private var homeTeamPlayersRecords: [PlayerRecord]!
    private var awayTeamPlayersRecords: [PlayerRecord]!
    private var fetchPlayerRecordsUseCase: FetchPlayerRecordsUseCase
    private var homeTeam: String
    private var awayTeam: String
    
    init(homeTeam: String, awayTeam: String, fetchPlayerRecordsUseCase: FetchPlayerRecordsUseCase) {
        self.homeTeamPlayersRecords = []
        self.awayTeamPlayersRecords = []
        self.error = ""
        self.homeTeam = homeTeam
        self.awayTeam = awayTeam
        self.fetchPlayerRecordsUseCase = fetchPlayerRecordsUseCase
        load(homeTeam: homeTeam, awayTeam: awayTeam)
    }
    
    func load(homeTeam:String, awayTeam: String) {
        fetchPlayerRecordsUseCase.execute(about: homeTeam) { result in
            switch result {
            case .success(let records):
                self.homeTeamPlayersRecords = records
                self.selectedPlayerTeam = records
            case .failure(let error):
                print(error.localizedDescription)
                self.errorHandler(error)
            }
        }
        fetchPlayerRecordsUseCase.execute(about: awayTeam) { result in
            switch result {
            case .success(let records):
                self.awayTeamPlayersRecords = records
            case .failure(let error):
                self.errorHandler(error)
            }
        }
        
    }
    
    func setSelectedTeam(index: Int) {
        if index == 0 {
            selectedPlayerTeam = homeTeamPlayersRecords
        } else {
            selectedPlayerTeam = awayTeamPlayersRecords
        }
    }
    
    func errorHandler(_ error: NetworkError) {
        switch error {
        case .network(description: let des):
            self.error = des
        case .parsing(description: let des):
            self.error = des
        }
    }
}
