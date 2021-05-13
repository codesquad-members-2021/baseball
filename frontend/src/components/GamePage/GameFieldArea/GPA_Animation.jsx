import React, { useState } from 'react';
import styled, { css, keyframes } from 'styled-components';
import { ReactComponent as Ghost } from './Ghost.svg';
function GhostAnimation({ move, setMove }) {
	console.log(move);
	const [ghostList, setGhostList] = useState([1]);
	if (move) {
		// setGhostList([...ghostList, 1]);
	}
	// const { state } = useGameState();
	// console.log(state);
	// 안타!
	// setGhostList([...ghostList, 1]);
	return <GhostSVG move={move} />;
}
export default GhostAnimation;
const GhostSVG = styled(Ghost)`
	position: absolute;
	width: 3rem;
	top: 52.5rem;
	left: 23rem;
	animation: run 2s forwards;
	${(props) =>
		props.move &&
		css`
			animation-name: ${run};
		`};
`; //트랜지션
const translateList = [
	[1, 0],
	[1, 1],
	[0, 1],
	[0, 0],
];

const XY = [
	[0, 0],
	[1, 0],
	[1, 1],
	[0, 1],
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

const GhostSvg = styled.svg`
	transition: all 0.5s linear;
	top: ${(props) => props.index}px;
	left: ${(props) => props.index}px;
	transform: ${(props) =>
		props.translate &&
		`translateX(${props.translate[0]}) translateY(${props.translate[1]})`};
`;

const run = keyframes`
from {
	transform: translateX(0rem) translateY(0rem);
}
to {
	transform: translateX(15rem) translateY(-12.5rem);
}`;
