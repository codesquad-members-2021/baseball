//
//  GameUpdatable.swift
//  baseball-game
//
//  Created by Song on 2021/05/07.
//

import Foundation

protocol GameUpdatable {

    func resetForNewInning(with newInning: Inning)
    
    func updateScore(with newScore: Score)
    
    func changePitcher(to newPitcher: Player)
    
    func changeBatter(to newBatter: Player)
    
    func updateBallCount(with ballChanged: BallChanged)
    
    func updateBase(with baseChanged: BaseChanged)
    
    func updatePitchList(with newPitch: Pitch)

}
