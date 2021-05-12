//
//  MatchView.swift
//  BaseballApp
//
//  Created by Song on 2021/05/04.
//

import UIKit

class GroundView: UIView {
    enum Constant {
        static let infieldSquareLineWidth: CGFloat = 5.0
        static let baseLineWidth: CGFloat = 1.0
        static let padding: CGFloat = 50.0
        static let baseDiagonalLength: CGFloat = 30.0
    }
    
    private let infieldSquareLayer = CAShapeLayer()
    private let homePlateLayer = CAShapeLayer()
    private var firstBaseLayer = CAShapeLayer()
    private var secondBaseLayer = CAShapeLayer()
    private var thirdBaseLayer = CAShapeLayer()
    
    override func awakeFromNib() {
        self.backgroundColor = .systemGray3
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        
        configureInfieldSquareLayer()
        configureHomePlateLayer()
        configureLayerForBases()
    }
    
    private func configureInfieldSquareLayer() {
        infieldSquareLayer.frame = CGRect(x: bounds.minX + Constant.padding,
                                          y: bounds.minY + Constant.padding,
                                          width: bounds.width - (Constant.padding * 2),
                                          height: bounds.height - (Constant.padding * 2))
        layer.addSublayer(infieldSquareLayer)
        infieldSquareLayer.strokeColor = UIColor.systemGray.cgColor
        infieldSquareLayer.fillColor = UIColor.clear.cgColor
        infieldSquareLayer.lineWidth = Constant.infieldSquareLineWidth
    }
    
    private func configureHomePlateLayer() {
        homePlateLayer.frame = CGRect(x: bounds.midX - 15.0,
                                      y: bounds.maxY - 70.0,
                                      width: 30.0,
                                      height: 45.0)
        layer.addSublayer(homePlateLayer)
        homePlateLayer.fillColor = UIColor.white.cgColor
    }
    
    private func configureLayerForBases() {
        firstBaseLayer = createBaseLayer(origin: CGPoint(x: bounds.maxX - Constant.padding - Constant.baseDiagonalLength / 2,
                                                      y: bounds.midY - Constant.baseDiagonalLength / 2))
        secondBaseLayer = createBaseLayer(origin: CGPoint(x: bounds.midX - Constant.baseDiagonalLength / 2,
                                                          y: bounds.minY + Constant.padding - Constant.baseDiagonalLength / 2))
        thirdBaseLayer = createBaseLayer(origin: CGPoint(x: bounds.minX + Constant.padding - Constant.baseDiagonalLength / 2,
                                                         y: bounds.midY - Constant.baseDiagonalLength / 2))
        
        infieldSquareLayer.path = createRhombusPath(for: infieldSquareLayer)
        homePlateLayer.path = createPlatePath(for: homePlateLayer)
        firstBaseLayer.path = createRhombusPath(for: firstBaseLayer)
        secondBaseLayer.path = createRhombusPath(for: secondBaseLayer)
        thirdBaseLayer.path = createRhombusPath(for: thirdBaseLayer)
    }
    
    private func createRhombusPath(for layer: CAShapeLayer) -> CGPath {
        let rhombusPath = UIBezierPath()
        rhombusPath.move(to: CGPoint(x: layer.bounds.midX, y: layer.bounds.maxY))
        rhombusPath.addLine(to: CGPoint(x: layer.bounds.minX, y: layer.bounds.midY))
        rhombusPath.addLine(to: CGPoint(x: layer.bounds.midX, y: layer.bounds.minY))
        rhombusPath.addLine(to: CGPoint(x: layer.bounds.maxX, y: layer.bounds.midY))
        rhombusPath.close()
        return rhombusPath.cgPath
    }
    
    private func createPlatePath(for layer: CAShapeLayer) -> CGPath {
        let platePath = UIBezierPath()
        platePath.move(to: CGPoint(x: layer.bounds.midX, y: layer.bounds.minY))
        platePath.addLine(to: CGPoint(x: layer.bounds.minX, y: layer.bounds.minY + 15.0))
        platePath.addLine(to: CGPoint(x: layer.bounds.minX, y: layer.bounds.minY + 15.0 + 30.0))
        platePath.addLine(to: CGPoint(x: layer.bounds.midX + 15.0, y: layer.bounds.minY + 15.0 + 30.0))
        platePath.addLine(to: CGPoint(x: layer.bounds.midX + 15.0, y: layer.bounds.minY + 15.0))
        platePath.close()
        return platePath.cgPath
    }
    
    private func createBaseLayer(origin: CGPoint) -> CAShapeLayer {
        let baseLayer = CAShapeLayer()
        baseLayer.frame = CGRect(origin: origin,
                                 size: CGSize(width: Constant.baseDiagonalLength, height: Constant.baseDiagonalLength))
        layer.addSublayer(baseLayer)
        baseLayer.strokeColor = UIColor.systemGray.cgColor
        baseLayer.fillColor = UIColor.white.cgColor
        baseLayer.lineWidth = Constant.baseLineWidth
        return baseLayer
    }
    
    @IBAction func pitchButtonPressed(_ sender: UIButton) {
            
    }
}
