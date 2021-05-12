import styled from 'styled-components';
import { theme } from '../Style/Theme';
import { useGameState } from '../GameContext';

const GamePlayers = () => {
	const {
		state: { gameStatusDTO, homeTeam, awayTeam },
	} = useGameState();

	const TeamPlayersInfo = () => {
		return gameStatusDTO ? (
			<>
				<Team>
					<Role>투수</Role>
					<Name>{homeTeam.players[gameStatusDTO.currentPitcher].name}</Name>
					<State>{homeTeam.players[gameStatusDTO.currentPitcher].id}</State>
				</Team>
				<Team>
					<Role>타자</Role>
					<Name>{awayTeam.players[gameStatusDTO.currentHitter].name}</Name>
					<State>
						{awayTeam.players[gameStatusDTO.currentHitter].plateAppearances}타석
						{awayTeam.players[gameStatusDTO.currentHitter].hitCount}안타
					</State>
				</Team>
			</>
		) : (
			<>
				<Team>
					<Role>투수</Role>
					<Name>{homeTeam.players[0].name}</Name>
					<State>{homeTeam.players[0].id}</State>
				</Team>
				<Team>
					<Role>타자</Role>
					<Name>{awayTeam.players[0].name}</Name>
					<State>0타석 0안타</State>
				</Team>
			</>
		);
	};

	return (
		<PlayerWrapper>
			<TeamPlayersInfo />
		</PlayerWrapper>
	);
};
const PlayerWrapper = styled.div`
	height: 12rem;
	border-bottom: 5px solid ${theme.colors.white};
	box-sizing: border-box;
`;
const Team = styled.div`
	margin: 20px;
	box-sizing: border-box;
`;
const Role = styled.span`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;
const Name = styled.span`
	margin-left: 10px;
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
