//
//  RxCollectionViewDataSourceProxy.swift
//  RxCocoa
//
//  Created by Krunoslav Zaher on 6/29/15.
//  Copyright © 2015 Krunoslav Zaher. All rights reserved.
//

#if os(iOS) || os(tvOS)

import UIKit
import RxSwift

extension UICollectionView: HasDataSource {
    public typealias DataSource = UICollectionViewDataSource
}

private let collectionViewDataSourceNotSet = CollectionViewDataSourceNotSet()

private final class CollectionViewDataSourceNotSet
    : NSObject
    , UICollectionViewDataSource {

    func collectionView(_ mainCollectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        0
    }
    
    // The cell that is returned must be retrieved from a call to -dequeueReusableCellWithReuseIdentifier:forIndexPath:
    func collectionView(_ mainCollectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        rxAbstractMethod(message: dataSourceNotSet)
    }
    
}

/// For more information take a look at `DelegateProxyType`.
open class RxCollectionViewDataSourceProxy
    : DelegateProxy<UICollectionView, UICollectionViewDataSource>
    , DelegateProxyType 
    , UICollectionViewDataSource {

    /// Typed parent object.
    public weak private(set) var mainCollectionView: UICollectionView?

    /// - parameter collectionView: Parent object for delegate proxy.
    public init(mainCollectionView: ParentObject) {
        self.mainCollectionView = mainCollectionView
        super.init(parentObject: mainCollectionView, delegateProxy: RxCollectionViewDataSourceProxy.self)
    }

    // Register known implementations
    public static func registerKnownImplementations() {
        self.register { RxCollectionViewDataSourceProxy(mainCollectionView: $0) }
    }

    private weak var _requiredMethodsDataSource: UICollectionViewDataSource? = collectionViewDataSourceNotSet

    // MARK: delegate

    /// Required delegate method implementation.
    public func collectionView(_ mainCollectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        (_requiredMethodsDataSource ?? collectionViewDataSourceNotSet).collectionView(mainCollectionView, numberOfItemsInSection: section)
    }
    
    /// Required delegate method implementation.
    public func collectionView(_ mainCollectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        (_requiredMethodsDataSource ?? collectionViewDataSourceNotSet).collectionView(mainCollectionView, cellForItemAt: indexPath)
    }

    /// For more information take a look at `DelegateProxyType`.
    open override func setForwardToDelegate(_ forwardToDelegate: UICollectionViewDataSource?, retainDelegate: Bool) {
        _requiredMethodsDataSource = forwardToDelegate ?? collectionViewDataSourceNotSet
        super.setForwardToDelegate(forwardToDelegate, retainDelegate: retainDelegate)
    }
}

#endif
