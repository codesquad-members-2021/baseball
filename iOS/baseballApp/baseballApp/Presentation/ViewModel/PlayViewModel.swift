import Foundation
import RxSwift
import RxCocoa

class PlayViewModel {
    private var play = [PlayDTO]()
    //private lazy var playStorage = BehaviorSubject<[PlayDTO]>(value: play)
    private var disposeBag = DisposeBag()
    
    
    
    func savePlay(from data: PlayDTO) {
        play.append(data)
       //playStorage.onNext(play)
    }
    
//    func getPlay() -> Observable<[PlayDTO]> {
//        return playStorage
//    }

    func getPlayInfo(gameID: Int, inningID: Int, _ completion: @escaping (PlayDTO)->Void) {
        try? APIService.shared.requestPlay(gameID: gameID, inningID: inningID)
            .subscribe { playData in
                    self.savePlay(from: playData)
                completion(playData)
            } onError: { error in
                print(error.localizedDescription)
            }.disposed(by: disposeBag)
    }
    
//    func getPitchInfo(gameID: Int, inningID: Int, _ completion: @escaping (PlayDTO)->Void) {
//        try? APIService.shared.requestPitch()
//            .subscribe { playData in
//                    self.savePlay(from: playData)
//                completion(playData)
//            } onError: { error in
//                print(error.localizedDescription)
//            }.disposed(by: disposeBag)
//    }
    
//    private func transformDTO(to play: PlayDTO, completion: @escaping (PlayDTO)->Void
//    ){
//        play.forEach { data in
//            completion(data)
//        }
//    }
}
