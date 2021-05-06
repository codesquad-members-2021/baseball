import UIKit

class HomeViewController: UIViewController {
    private var handler: ((Result<GameDTO, API.APIError>) -> Void)!
    
    @IBAction func buttonTouched(_ sender: Any) {
        API.shared.get(completionHandler: handler)
    }
    
   
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        handler = { [weak self] result in
            guard let self = self else {  return }
            switch result {
            case .success(let games):
                self.setInfo(by: games)
            case .failure(let error):
                print("Error", error.localizedDescription)
                self.setError()
            }
        }
    }
    
    private func setInfo(by data: GameDTO) {
        DispatchQueue.main.async {
            data.body.forEach { game in
                print("""
                 ID: \(game.id)\n
                 HOME: \(game.homeTeam)\n
                 AWAY: \(game.awayTeam)\n
                 
                """
                )
            }
            
        }
        
    }
    
    private func setError() {
        DispatchQueue.main.async {
            print("""
                ID: Error\n
                Title: Error\n
                UserId: Error\n
                Body: Error\n
               """
            )
        }
    }
}

