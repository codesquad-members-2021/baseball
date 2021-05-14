import React, { useState, useEffect } from 'react';
import styled, { css, keyframes } from 'styled-components';
import { ReactComponent as Ghost } from './Ghost.svg';
import { useLogState, useLogDispatch } from '../../GameContext';

const playerruntype = [
	'translateX(20.5rem)',
	'translateY(-19.5rem)',
	'translateX(-20.5rem)',
	'translateY(19.5rem)',
];

function GhostAnimation() {
	const [istransition, setIsTransition] = useState(false);
	const [base, setBase] = useState([1]);
	const [moveCount, setMoveCount] = useState(0);
	const logInfo = useLogState();
	const { logState } = logInfo;
	let BallType;

	useEffect(() => {
		if (logState.length > 0) {
			BallType = logState[logState.length - 1].pitchResult.playType;
			if (
				BallType === 'HOMERUN' ||
				BallType === 'HITS' ||
				BallType === 'FOUR_BALL'
			) {
				setMoveCount(base.length);
				setIsTransition(() => true);
			}
		}
	}, [logState]);

	const handleTransitionEnd = () => {
		if (moveCount > 1) {
			setMoveCount(moveCount - 1);
		} else {
			setMoveCount(moveCount - 1);
			setBase((base) => [...base, 1]);
			setIsTransition(() => false);
		}
	};

	useEffect(() => {
		if (base.length === 5) setBase([...base.slice(-4)]);
	}, [base]);

	return (
		<Ground>
			{base.map((v, i) => (
				<div key={i}>
					<GhostSVG
						visible={v < 1 && 'hidden'}
						playerruntype={playerruntype[i]}
						className="ghost-svg"
						onTransitionEnd={handleTransitionEnd}
						istransition={istransition}
					/>
				</div>
			))}
		</Ground>
	);
}
export default GhostAnimation;

const Ground = styled.div`
	position: relative;
	top: -0.5rem;
	left: -1rem;
	width: 20rem;
	height: 28rem;
	margin: auto;
	transform: rotate(-45deg);
	& > div:nth-child(1) {
		position: absolute;
		bottom: 0;
		left: 0;
		&:after {
			content: '';
			position: absolute;
			width: 4.5rem;
			height: 4.5rem;
			top: 3.9rem;
			left: -1.6rem;
			background-color: #fff;
		}
	}
	& > div:nth-child(2) {
		position: absolute;
		bottom: 0;
		right: 0;
	}
	& > div:nth-child(3) {
		position: absolute;
		top: 0;
		right: 0;
	}
	& > div:nth-child(4) {
		position: absolute;
		top: 0;
		left: 0;
	}
`;

const GhostSVG = styled(Ghost)`
	width: 3rem;
	visibility: ${(props) => props.visible};
	transition: ${(props) => (props.istransition ? 'all 0.5s' : '')};
	transform: ${(props) =>
		(props.istransition && props.playerruntype) || 'translate(0px, 0px)'};
`;
