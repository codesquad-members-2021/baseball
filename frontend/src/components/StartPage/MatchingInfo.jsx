import styled from 'styled-components';
import { useHistory } from 'react-router-dom';
import useFetch from '../Hook/useFetch';
import { theme } from '../Style/Theme';
import { useState, useCallback } from 'react';

const MatchingInfo = ({ setMessage, data }) => {
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
			console.log(occupiedState);
			if (!occupied && type === 'HOME') {
				history.push(`/defense/${id}`);
			} else if (!occupied && type === 'AWAY') {
				history.push(`/attack/${id}`);
			} else {
				//occupied=true인경우(409error)
				setMessage(`이미 게임이 시작되었습니다. \n다른 팀을 선택해주세요`);
				console.log(data);
			}
		},
		[history],
	);
	return (
		<TeamWrapper>
			<TeamName onClick={() => handleClick(data.id, 'AWAY')}>
				{data.awayTeam.teamName}
			</TeamName>
			<VS>VS</VS>
			<TeamName onClick={() => handleClick(data.id, 'HOME')}>
				{data.homeTeam.teamName}
			</TeamName>
		</TeamWrapper>
	);
};
const VS = styled.div`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.grey_deep};
`;
const TeamName = styled.span`
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
	cursor: pointer;
	&:hover {
		color: ${theme.colors.red};
	}
`;
const TeamWrapper = styled.div`
	display: flex;
	align-items: center;
	justify-content: space-around;
	padding: 0 30px;
`;

export default MatchingInfo;
