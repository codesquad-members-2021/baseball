import React from 'react';
import { theme, AlignTextCenter } from '../Style/Theme';
import styled from 'styled-components';
const GameGeneralInfo = ({ data }) => {
	console.log(data);
	return (
		<Border>
			<Title>BASEBALL GAME ONLINE</Title>
			<FlexBox>
				<TeamName>{data.awayTeam.teamName}</TeamName>
				<TeamName>{data.awayTeam.teamName}</TeamName>
				<VS>VS</VS>
				<TeamName>{data.homeTeam.teamName}</TeamName>
				<TeamName>{data.homeTeam.teamName}</TeamName>
			</FlexBox>
		</Border>
	);
};

const Border = styled.div`
	text-align: center;
	border: 1px solid blue;
`;

const FlexBox = styled.div`
	display: flex;
	justify-contents: center;
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
