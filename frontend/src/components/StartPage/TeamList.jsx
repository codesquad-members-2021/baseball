import React, { useState, useEffect, useCallback } from 'react';
import styled from 'styled-components';
import { theme } from '../Style/Theme';
import { Link, useHistory } from 'react-router-dom';
import useFetch from '../Hook/useFetch';
import MatchingInfo from './MatchingInfo';
const TeamList = (props) => {
	const [teamData, loading, error] = useFetch('get', 'teamList');
	const teamListData = !loading && teamData.games;

	const [currentID, setID] = useState(null);
	const [occupiedState, loadingOccupiedState, occupied] = useFetch(
		'patch',
		'initGame',
		currentID,
	);

	const history = useHistory();
	const handleClick = useCallback(
		async (id, type) => {
			await setID(id);
			if (!occupied && type === 'HOME') {
				history.push(`/defense/${id}`);
			} else if (!occupied && type === 'AWAY') {
				history.push(`/attack/${id}`);
			}
		},
		[history],
	);

	const Lists = () => {
		return teamListData.map((team, i) => (
			<SingleList key={i}>
				<GameTitle>{team.gameTitle}</GameTitle>
				<MatchingInfo data={team}></MatchingInfo>
			</SingleList>
		));
	};

	return !loading && <Lists />;
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
