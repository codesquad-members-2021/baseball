//
//  PlayViewController.swift
//  ProBaseball
//
//  Created by 조중윤 on 2021/05/04.
//

import UIKit

enum BallCountSection: CaseIterable {
    case main
}

class PlayViewController: UIViewController {
    @IBOutlet weak var ballCountCollectionView: UICollectionView!
    lazy var dataSource = configureDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.ballCountCollectionView.backgroundColor = .red
        ballCountCollectionView.register(UINib(nibName: "BallCountCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "BallCountCollectionViewCell")
        ballCountCollectionView.dataSource = dataSource
        ballCountCollectionView.delegate = self
        updateSnapshot()
        
    }
    
    func configureDataSource() -> UICollectionViewDiffableDataSource<BallCountSection, String> {
        let dataSource = UICollectionViewDiffableDataSource<BallCountSection, String>(collectionView: ballCountCollectionView) { (collectionView, indexPath, icon) -> UICollectionViewCell? in
     
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "BallCountCollectionViewCell", for: indexPath) as! BallCountCollectionViewCell
//            cell.homeTeamLabel.text = "hhhh"
            cell
            return cell
        }
        return dataSource
    }
    
    func updateSnapshot(animatingChange: Bool = false) {
        var snapshot = NSDiffableDataSourceSnapshot<BallCountSection, String>()
        snapshot.appendSections(BallCountSection.allCases)
        snapshot.appendItems(["sdf"], toSection: BallCountSection.main)
     
        dataSource.apply(snapshot, animatingDifferences: false)
    }
}

extension PlayViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: self.ballCountCollectionView.frame.width, height: self.ballCountCollectionView.frame.height / 6)
    }
}
