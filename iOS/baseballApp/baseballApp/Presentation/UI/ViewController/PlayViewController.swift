import UIKit

class PlayViewController: UIViewController {

    @IBOutlet weak var stadiumView: StadiumView!
    @IBOutlet weak var ballListView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        ballListView.register(UINib(nibName: "BallListCell", bundle: nil), forCellReuseIdentifier: "BallListCell")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        stadiumView.backgroundColor = .red
    }
}
