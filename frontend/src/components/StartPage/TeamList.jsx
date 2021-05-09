import styled from 'styled-components';
import { theme } from '../Style/Theme';
import useFetch from '../Hook/useFetch';
import MatchingInfo from './MatchingInfo';
const TeamList = ({ setMessage }) => {
	const [teamData, loading, error] = useFetch('get', 'teamList');
	const teamListData = !loading && teamData.games;

	return (
		!loading &&
		teamListData.map((team, i) => (
			<SingleList key={i}>
				<GameTitle>{team.gameTitle}</GameTitle>
				<MatchingInfo setMessage={setMessage} data={team}></MatchingInfo>
			</SingleList>
		))
	);
};

const SingleList = styled.div`
	width: 337px;
	height: 85px;
	margin: 10px;
	background: ${theme.colors.list_color};
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
