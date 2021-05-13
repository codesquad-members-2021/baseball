import React, { useState, useEffect } from 'react';
import styled, { css, keyframes } from 'styled-components';
import { ReactComponent as Ghost } from './Ghost.svg';
import { useLogState, useLogDispatch } from '../../GameContext';

const playerRunType = [
	'translateX(20.5rem)',
	'translateY(-19.5rem)',
	'translateX(-20.5rem)',
	'translateY(19.5rem)',
];

function GhostAnimation({ move, setMove }) {
	// console.log(move);
	const [ghostList, setGhostList] = useState([]);
	const [isTransition, setIsTransition] = useState(false);
	useEffect(() => {
		if (move) {
			setGhostList(() => [...ghostList, 1]);
			setIsTransition(true);
		}
	}, [move]);

	useEffect(() => {
		console.log(ghostList);
		setMove(() => false);
	}, [ghostList]);

	const handleTransitionEnd = () => {
		console.log('트랜지션 끝났어요!');
		setIsTransition(false);
	};
	// const { state } = useGameState();
	// console.log(state);
	// 안타!
	// setGhostList([...ghostList, 1]);
	return (
		<Ground>
			<div>
				<GhostSVG className="ghost-svg" />
			</div>
			{ghostList.map((v, i) => (
				<div key={i}>
					<GhostSVG
						playerRunType={playerRunType[i]}
						className="ghost-svg"
						onTransitionEnd={handleTransitionEnd}
						isTransition={isTransition}
					/>
				</div>
			))}
		</Ground>
	);
}
export default GhostAnimation;

const Ground = styled.div`
	position: relative;
	top: 31.5rem;
	left: -14rem;
	width: 22rem;
	height: 21rem;
	margin: auto;
	transform: rotate(-45deg);
	& > div:nth-child(1) {
		position: absolute;
		bottom: 0;
		left: 0;
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

/*
const GhostSVG = styled(Ghost)`
	position: absolute;
	width: 3rem;
	top: 52.5rem;
	left: 23rem;
	animation: run 2s forwards;
	${(props) =>
		props.move === 'true' &&
		css`
			animation-name: ${run};
		`};
`; //트랜지션
*/

const GhostSVG = styled(Ghost)`
	width: 3rem;
	transition: ${({ isTransition }) => (isTransition ? 'all 0.5s' : '')};
	transform: ${(props) => props.isTransition && props.playerRunType};
`;

/*
 3 <---------- 2
  ------------ ^
  |          | |
  |          | |
  |          | |
  ------------ |
0 -----------> 1
*/
/*
const Plate = () => {
	// 최초에는 빈 배열!
	const [ghostList, setGhostList] = useState([]);
	// 안타!
	setGhostList([...ghostList, 1]);
	return (
		<>
			{ghostList.map((v, i) => (
				<GhostSvg key={i} translate={translateList[i]} index={i} />
			))}
		</>
	);
};
*/

/*
const GhostSvg = styled.svg`
	transition: all 0.5s linear;
	top: ${(props) => props.index}px;
	left: ${(props) => props.index}px;
	transform: ${(props) =>
		props.translate &&
		`translateX(${props.translate[0]}px) translateY(${props.translate[1]}px)`};
`;
*/
// const run = keyframes`
// from {
// 	transform: translateX(0rem) translateY(0rem);
// }
// to {
// 	transform: translateX(15rem) translateY(-12.5rem);
// }`;
