import React, { useState } from 'react';
import { theme } from '../Style/Theme';
import styled from 'styled-components';
import { useGameState } from '../GameContext';

const GameGeneralInfo = ({ type }) => {
	const { state } = useGameState();
	const [away_score, setAwayScore] = useState(
		state.score ? state.score.awayTeamScore : 0,
	);
	const [home_score, setHomeScore] = useState(
		state.score ? state.score.homeTeamScore : 0,
	);

	return (
		<InfoWrapper>
			<Title>BASEBALL GAME ONLINE</Title>
			<FlexBox>
				<TeamName>{state.awayTeam.teamName}</TeamName>
				<TeamBlock>
					<TeamName>{away_score}</TeamName>
					{type === 'Defense' && <MyTeam>Player</MyTeam>}
				</TeamBlock>
				<VS>VS</VS>
				<TeamName>{home_score}</TeamName>
				<TeamBlock>
					<TeamName>{state.homeTeam.teamName}</TeamName>
					{type === 'Attack' && <MyTeam>Player</MyTeam>}
				</TeamBlock>
			</FlexBox>
		</InfoWrapper>
	);
};

const InfoWrapper = styled.div`
	height: 12rem;
	box-sizing: border-box;
	padding: 30px;
	text-align: center;
	border-bottom: 5px solid ${theme.colors.white};
	border-right: 5px solid ${theme.colors.white};
`;
const FlexBox = styled.div`
	display: flex;
	justify-content: center;
	align-items: flex-Start;
`;
const Title = styled.div`
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;
const TeamBlock = styled.div``;
const TeamName = styled.div`
	margin: 20px 20px 0 20px;
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;
const MyTeam = styled.span`
	font-size: ${theme.fontSize.small};
	font-weight: ${theme.fontWeight.normal};
	color: ${theme.colors.red};
`;
const VS = styled.div`
	margin: 30px;
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.grey};
`;

export default GameGeneralInfo;
