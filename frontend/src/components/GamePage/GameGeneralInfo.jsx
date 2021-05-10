import React, { useState } from 'react';
import { theme } from '../Style/Theme';
import styled from 'styled-components';
const GameGeneralInfo = ({ data }) => {
	const [away_score, setAwayScore] = useState(0);
	const [home_score, setHomeScore] = useState(0);
	return (
		<InfoWrapper>
			<Title>BASEBALL GAME ONLINE</Title>
			<FlexBox>
				<TeamName>{data.awayTeam.teamName}</TeamName>
				<TeamName>{away_score}</TeamName>
				<VS>VS</VS>
				<TeamName>{home_score}</TeamName>
				<TeamName>{data.homeTeam.teamName}</TeamName>
			</FlexBox>
		</InfoWrapper>
	);
};

const InfoWrapper = styled.div`
	padding: 30px;
	text-align: center;
	border-bottom: 5px solid ${theme.colors.white};
	border-right: 5px solid ${theme.colors.white};
`;

const FlexBox = styled.div`
	display: flex;
	justify-content: center;
	align-items: center;
`;
const Title = styled.div`
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;

const TeamName = styled.span`
	margin: 20px;
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;

const VS = styled.div`
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.grey};
`;

export default GameGeneralInfo;
