import React from 'react';
import styled from 'styled-components';
import { theme } from '../Style/Theme';
const GamePlayers = () => {
	return (
		<PlayerWrapper>
			<Team>
				<Role>투수</Role>
				<Name>최동원</Name>
				<State>#39</State>
			</Team>
			<Team>
				<Role>타자</Role>
				<Name>류현진</Name>
				<State> 1타석 0안타</State>
			</Team>
		</PlayerWrapper>
	);
};
const PlayerWrapper = styled.div`
	border-bottom: 5px solid ${theme.colors.white};
`;
const Team = styled.div`
	margin: 20px;
`;
const Role = styled.span`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;
const Name = styled.span`
	font-size: ${theme.fontSize.medium};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.skyblue_log};
`;
const State = styled.div`
	font-size: ${theme.fontSize.medium};
	font-weight: ${theme.fontWeight.normal};
	color: ${theme.colors.blue_log};
`;
export default GamePlayers;
