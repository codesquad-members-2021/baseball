import { useEffect } from 'react';
import styled from 'styled-components';
import { theme } from '../Style/Theme';
import { useGameState } from '../GameContext';
const GameDetailScore = () => {
	const { state } = useGameState();

	const totalInning = Array.from({ length: 14 }, (v, i) => i);
	totalInning[0] = null;
	totalInning[totalInning.length - 1] = 'R';

	const ScoreTop = totalInning.map((v, i) => <Block key={'a' + i}>{v}</Block>);
	const teamHome = Array.from({ length: 14 }, (v, i) =>
		i === 0 ? <Block key={'b' + i}>{state.homeTeam.teamName}</Block> : null,
	);
	const teamAway = Array.from({ length: 14 }, (v, i) =>
		i === 0 ? <Block key={'c' + i}>{state.awayTeam.teamName}</Block> : null,
	);
	if (state.score) {
		const scoreState = state.score.innings;
		scoreState.map((el, idx) => {
			teamHome[idx + 1] = <Block key={'d' + idx}>{el.homeTeamScore}</Block>;
			teamAway[idx + 1] = <Block key={'e' + idx}>{el.awayTeamScore}</Block>;
		});
	}

	return (
		<ScoreDivWrapper>
			<ScoreWrapper>
				<ScoreBlock>{ScoreTop}</ScoreBlock>
				<TeamScoreBlock>{teamAway}</TeamScoreBlock>
				<TeamScoreBlock>{teamHome}</TeamScoreBlock>
			</ScoreWrapper>
		</ScoreDivWrapper>
	);
};
const Block = styled.div`
	width: 60px;
`;

const TeamScoreBlock = styled.div`
	width: fit-content;
	display: flex;
	margin-top: 10px;
	font-size: ${theme.fontSize.large};
	color: ${theme.colors.white};
`;
const ScoreBlock = styled.div`
	display: flex;
	font-size: ${theme.fontSize.X_large};
	color: ${theme.colors.white};
	border-bottom: 3px solid ${theme.colors.white};
	width: fit-content;
`;
const ScoreWrapper = styled.div`
	padding: 20px;
	box-sizing: border-box;
`;
const ScoreDivWrapper = styled.div`
	position: absolute;
	width: 100%;
	height: 30%;
	display: flex;
	justify-content: center;
	background-color: ${theme.colors.black};
	z-index: 9999;
`;
export default GameDetailScore;
