import React, { useState } from 'react';
import styled, { css, keyframes } from 'styled-components';
import { theme, Span } from '../../Style/Theme';
import { ReactComponent as Field } from './Field.svg';
import { ReactComponent as Ghost } from './ghost.svg';
import API from '../../Hook/API';
import { GameProvider, useGameState, useDispatch } from '../../GameContext';

const run = keyframes`
from {
	transform: translateX(0rem) translateY(0rem);
}
to {
	transform: translateX(15rem) translateY(-12.5rem);
}`;

const GPA_Field = ({ type, gameId }) => {
	const { state } = useGameState();
	const [move, setMove] = useState(false);
	const dispatch = useDispatch();

	const [inning, setInning] = useState(
		state.score ? state.gameStatusDTO.inning : 1,
	);
	const handleClick = () => {
		const pitchResult = async () => {
			const response = await API.post.pitch(gameId);
			dispatch({ type: 'pitch', payload: response });
		};
		pitchResult();
		setMove(true);
	};

	return (
		<>
			{type === 'Attack' && <PITCH onClick={handleClick}>PITCH</PITCH>}
			<FieldArea>
				<GameState>{inning}회초 공격</GameState>
				<FieldSVG />
				<GhostSVG move={move} />
			</FieldArea>
		</>
	);
};

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

const PITCH = styled.button`
	position: absolute;
	top: 23rem;
	left: 3rem;
	cursor: pointer;
	z-index: 9999;
	background-color: ${theme.colors.transparent};
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.Bold};
	color: ${theme.colors.white};
	border: 5px solid ${theme.colors.white};
`;
const FieldArea = styled.div`
	position: relative;
`;

const FieldSVG = styled(Field)`
	position: absolute;
	top: 23rem;
	left: 3rem;
`;

const GameState = styled(Span)`
	position: absolute;
	top: 17rem;
	right: 23rem;
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.light};
	color: ${theme.colors.white};
`;
export default GPA_Field;
