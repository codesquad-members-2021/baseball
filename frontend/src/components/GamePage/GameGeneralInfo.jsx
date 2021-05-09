import React from 'react';
import { theme } from '../Style/Theme';
import styled from 'styled-components';
const GameGeneralInfo = ({ data }) => {
	console.log(data);
	return (
		<>
			<Title>BASEBALL GAME ONLINE</Title>
			<FlexBox>
				<TeamName>주나미</TeamName>
				<TeamName>{data.awayTeamScore}</TeamName>
				<VS>VS</VS>

				<TeamName>{data.homeTeamScore}</TeamName>
				<TeamName>시에나</TeamName>
			</FlexBox>
		</>
	);
};

const FlexBox = styled.div`
	display: flex;
`;
const Title = styled.div`
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;

const TeamName = styled.span`
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;

const VS = styled.div`
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.grey};
`;

export default GameGeneralInfo;
