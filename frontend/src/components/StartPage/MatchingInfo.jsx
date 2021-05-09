import styled from 'styled-components';
import { useHistory } from 'react-router-dom';
import useFetch from '../Hook/useFetch';
import { theme } from '../Style/Theme';
import { useState, useEffect, useCallback } from 'react';
const MatchingInfo = ({ data }) => {
	const [currentID, setID] = useState(null);
	const [occupiedState, loadingOccupiedState, occupied] = useFetch(
		'patch',
		'initGame',
		currentID,
	);
	console.log(occupiedState);
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
	//home, away 팀데이터 내부에 occupied가 있던데, 그럼 전체 팀의 occupied가 아니라 클릭 팀별 occupied를 체크해야하는거 아닌가? 아니면 팀별 occupied를 지우고 전체 occupied (pc:사용자)로 정확히 컨셉잡아야함.
	//그냥 occupied 확인 요청은 occupied여부만 체크하며 넘어가고, occupied false일때 화면전환 한 후에 초기 및 게임정보 가져오는 방식으로 바꾸자. 너무 힘들다

	return (
		<TeamWrapper>
			<TeamName onClick={() => handleClick(data.id, 'AWAY')}>
				{data.awayTeam.teamName}
			</TeamName>
			<span>VS</span>
			<TeamName onClick={() => handleClick(data.id, 'HOME')}>
				{data.homeTeam.teamName}
			</TeamName>
		</TeamWrapper>
	);
};

const TeamName = styled.span`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.black};
	cursor: pointer;

	&:hover {
		color: ${theme.colors.red};
	}
`;

const TeamWrapper = styled.div`
	display: flex;
	align-items: center;
	justify-content: space-between;
	overflow: hidden;
	height: 55px;
	padding: 0 30px;
`;

export default MatchingInfo;
