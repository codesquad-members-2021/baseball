import React, { useState, useEffect } from 'react';
import styled, { css, keyframes } from 'styled-components';
import { theme, Span } from '../../Style/Theme';
import { ReactComponent as Field } from './Field.svg';
import API from '../../Hook/API';
import { useGameState, useDispatch } from '../../GameContext';
import GhostAnimation from './GPA_Animation';

const GpaField = ({ type, gameId }) => {
	const { state } = useGameState();
	const dispatch = useDispatch();
	const [inning, setInning] = useState(
		state.score ? state.gameStatusDTO.inning : 1,
	);

	if (state.pitchResult) console.log(state.pitchResult.playType);

	const handleClick = () => {
		const getPitchResult = async () => {
			const response = await API.post.pitch(gameId);
			dispatch({ type: 'pitch', payload: response });
		};

		getPitchResult();
	};

	const move =
		state.pitchResult && state.pitchResult.playType === 'HITS' ? true : false;

	return (
		<>
			{type === 'Attack' && <PITCH onClick={handleClick}>PITCH</PITCH>}
			<FieldArea>
				<GameState>{inning}회초 공격</GameState>
				<FieldSVG />
				<GhostAnimation move={move} />
			</FieldArea>
		</>
	);
};

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
export default GpaField;
