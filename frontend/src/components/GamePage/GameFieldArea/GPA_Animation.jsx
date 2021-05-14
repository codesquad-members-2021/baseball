import React, { useState, useEffect } from 'react';
import styled, { css, keyframes } from 'styled-components';
import { ReactComponent as Ghost } from './Ghost.svg';
import { useLogState, useLogDispatch } from '../../GameContext';
function GhostAnimation({ move, setMove }) {
	// console.log(move);
	const [ghostList, setGhostList] = useState([1]);
	useEffect(() => {
		if (move) {
			setGhostList(() => [...ghostList, 1]);
		}
	}, [move]);

	useEffect(() => {
		console.log(ghostList);
		setMove(() => false);
	}, [ghostList]);

	const handleTransitionEnd = () => {
		console.log('트랜지션 끝났어요!');
	};

	// const { state } = useGameState();
	// console.log(state);
	// 안타!
	// setGhostList([...ghostList, 1]);
	return ghostList
		.reverse()
		.map((v, i) => (
			<GhostSVG
				className="ghost-svg"
				translate={translateList[i]}
				XY={XY[i]}
				onTransitionEnd={handleTransitionEnd}
			/>
		));
}
export default GhostAnimation;
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

// 임시에요!
// const run = [
// 	keyframes`
// 		from {
// 			transform: translate(0, 0);
// 		}
// 		to {
// 			transform: translate(0, 0);
// 		}
// 	`,
// 	keyframes`
// 		from {
// 			transform: translate(0, 0);
// 		}
// 		to {
// 			transform: translate(245px, -200px);
// 		}
// 	`,
// ];

const run1 = keyframes`
	from {
		transform: translate(0, 0);
	}
	to {
		transform: translate(0, 0);
	}
`;
const run2 = keyframes`
	from {
		transform: translate(-245px, 200px);
	}
	to {
		transform: translate(0, 0);
	}
`;

const GhostSVG = styled(Ghost)`
	position: absolute;
	top: ${(props) => props.XY[0]};
	left: ${(props) => props.XY[1]};
	width: 3rem;
	&:nth-of-type(1) {
		width: 5rem;
		animation: ${run1} 2s 1s linear alternate;
	}
	&:nth-of-type(2) {
		animation: ${run2} 2s 1s linear alternate;
	}
`;

const translateList = ['translate(0px, 0px)', 'translate(245px, -200px)'];

const XY = [
	// top, left
	['40.0rem', '38.3rem'],
	['52.5rem', '23rem'],
	['52.5rem', '23rem'],
	[100, 100],
	[0, 100],
];

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
