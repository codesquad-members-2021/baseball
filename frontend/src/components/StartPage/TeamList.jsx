import React, { useState, useCallback } from 'react';
import styled from 'styled-components';
import { theme } from '../Style/Theme';
import useFetch from '../Hook/useFetch';
import MatchingInfo from './MatchingInfo';
const TeamList = (props) => {
	const [teamData, loading, error] = useFetch('get', 'teamList');
	const teamListData = !loading && teamData.games;

	return (
		!loading &&
		teamListData.map((team, i) => (
			<SingleList key={i}>
				<GameTitle>{team.gameTitle}</GameTitle>
				<MatchingInfo data={team}></MatchingInfo>
			</SingleList>
		))
	);
};

const SingleList = styled.div`
	width: 337px;
	height: 85px;
	margin: 10px;
	background: #c4c4c4;
	border-radius: 12px;
`;

const GameTitle = styled.div`
	font-size: ${theme.fontSize.small};
	font-weight: ${theme.fontWeight.normal};
	color: ${theme.colors.red};
	padding-top: 5px;

	text-align: center;
`;

export default TeamList;
