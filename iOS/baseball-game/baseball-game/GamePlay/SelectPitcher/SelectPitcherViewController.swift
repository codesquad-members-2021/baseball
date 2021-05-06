//
//  SelectPitcherViewController.swift
//  baseball-game
//
//  Created by Song on 2021/05/04.
//

import UIKit

class SelectPitcherViewController: UIViewController {

    @IBOutlet weak var pitcherCollectionView: UICollectionView!
    
    private let cellId = "selectPitcherCell"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        pitcherCollectionView.dataSource = self
    }
    
    @IBAction func closeTouched(_ sender: Any) {
        dismiss(animated: true, completion: nil)
    }
    
}

//임시 코드 - diffable로 변경
extension SelectPitcherViewController: UICollectionViewDataSource {
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 10
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: cellId, for: indexPath)
        return cell
    }

}
