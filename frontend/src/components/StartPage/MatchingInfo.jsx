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
			if (!occupied && type === 'HOME') {
				history.push(`/defense/${id}`);
			} else if (!occupied && type === 'AWAY') {
				history.push(`/attack/${id}`);
			} else {
				setMessage(`이미 게임이 시작되었습니다. \n다른 팀을 선택해주세요`);
				//occupied=true인경우(409error)
			}
		},
		[history],
	);

	//?1. home, away 팀데이터 내부에 occupied가 있던데, 클릭 팀별 occupied를 체크해야하는 구조인가? 그리고 그렇다면 pc:사용자가 아닌 사용자:사용자 컨셉이 되어야 할듯.
	//?    [대기중] marble : 삼다수 [입장하기]
	//?2. 그냥 occupied 확인 요청은 occupied여부만 체크하며 넘어가고,
	//?   occupied false일때 화면전환 한 후에 초기 및 게임정보 가져오는 방식으로 바꾸자. 너무 힘들다
	//?3. 초기 occupied 상태가 true인것 teamList조회시 알려주기
	//?   ->선택불가팀은 미리 클릭방지?
	//?   ->setMessage가 작동하는지 체크해보기.

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
	overflow: hidden;
	padding: 0 30px;
`;

export default MatchingInfo;
