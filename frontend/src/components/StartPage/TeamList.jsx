import React, { useState } from 'react';
import styled from 'styled-components';
import { theme } from '../Style/Theme';
import { Redirect, Link } from 'react-router-dom';
import useFetch from '../Hook/useFetch';
const TeamList = () => {
	//! USEfETCh _ Test
	const [teamData, loadingTeamData, error1] = useFetch('get', 'teamList');
	const teamListData = teamData.games;

	const [currentID, setID] = useState(null);
	const [occupiedState, loadingOccupiedState, error2] = useFetch(
		'get',
		'initData',
		currentID,
	);

	return (
		!loadingTeamData &&
		teamListData.map((team, i) => (
			<SingleList key={i}>
				<div>{team.gameTitle}</div>
				<GameTitle>
					<TeamName onClick={() => setID(team.id)}>
						{/* <Redirect
							to={`/attack/${team.id}/${team.awayTeam.teamName}/${team.homeTeam.teamName}`}
						></Redirect> */}
						{team.awayTeam.teamName}
					</TeamName>
					<span>VS</span>
					<TeamName>
						<Link to="/defense">{team.homeTeam.teamName}</Link>
					</TeamName>
				</GameTitle>
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
`;

const TeamName = styled.span`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.black};
`;
export default TeamList;
