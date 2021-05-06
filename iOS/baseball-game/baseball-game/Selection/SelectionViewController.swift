//
//  SelectionViewController.swift
//  baseball-game
//
//  Created by Lia on 2021/05/03.
//

import UIKit

class SelectionViewController: UIViewController {

    @IBOutlet weak var backgroundView: UIView!
    @IBOutlet weak var gameListTableView: UITableView!
    
    private let gradientLayer: CAGradientLayer = CAGradientLayer()
    
    var viewModel = SelectViewModel()
    private var dataSource: UITableViewDiffableDataSource<Section, Game>!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setBackground()
        
        self.viewModel.request()
        self.registerNib()
        self.configureDataSource()
        self.createSnapshot()
    }
}


extension SelectionViewController {
    enum Section {
        case main
    }
    
    private func registerNib() {
        self.gameListTableView.register(GameCell.nib, forCellReuseIdentifier: GameCell.reuseIdentifier)
    }
    
    private func configureDataSource() {
        self.dataSource = UITableViewDiffableDataSource.init(tableView: self.gameListTableView) { (tableView, indexPath, game) -> UITableViewCell in
            
            let cell = self.gameListTableView.dequeueReusableCell(withIdentifier: GameCell.reuseIdentifier) as! GameCell
            cell.fill(self.viewModel, state: game)
            
            return cell
        }
    }
    
    private func createSnapshot() {
        var snapshot = NSDiffableDataSourceSnapshot<Section, Game>()
        
        snapshot.appendSections([.main])
        viewModel.didFetchData { games in
            snapshot.appendItems(games)
            self.dataSource.apply(snapshot)
        }
    }
}


extension SelectionViewController {

    private func setBackground() {
        self.gradientLayer.colors = [#colorLiteral(red: 0, green: 0, blue: 0, alpha: 1).cgColor, #colorLiteral(red: 0.06274510175, green: 0, blue: 0.1921568662, alpha: 1).cgColor, #colorLiteral(red: 0.1921568662, green: 0.007843137719, blue: 0.09019608051, alpha: 1).cgColor, #colorLiteral(red: 0.06274510175, green: 0, blue: 0.1921568662, alpha: 1).cgColor, #colorLiteral(red: 0, green: 0, blue: 0, alpha: 1).cgColor]
        self.gradientLayer.startPoint = CGPoint(x: 0, y: 0)
        self.gradientLayer.endPoint = CGPoint(x: 1, y: 1)
        self.gradientLayer.frame = self.view.bounds
        self.backgroundView.layer.addSublayer(self.gradientLayer)
    }
}
