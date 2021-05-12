import styled from 'styled-components';
import { theme } from '../Style/Theme';
import { useGameState } from '../GameContext';

const GamePlayers = () => {
	// const { state } = useGameState();
	const {
		state: { gameStatusDTO, homeTeam, awayTeam },
	} = useGameState();

	// const { state: 이름 } = useGameState();

	const TeamPlayersInfo = () => {
		// if (state.gameStatusDTO) {
		// 	const pitcher =
		// 		state.homeTeam.players[state.gameStatusDTO.currentPitcher];
		// 	const hitter = state.awayTeam.players[state.gameStatusDTO.currentHitter];
		// 	console.log(pitcher, hitter);
		// }

		return gameStatusDTO ? (
			<>
				<Team>
					<Role>투수</Role>
					<Name>
						{state.homeTeam.players[state.gameStatusDTO.currentPitcher].name}
					</Name>
					<State>
						{state.homeTeam.players[state.gameStatusDTO.currentPitcher].id}
					</State>
				</Team>
				<Team>
					<Role>타자</Role>
					<Name>
						{state.awayTeam.players[state.gameStatusDTO.currentHitter].name}
					</Name>
					<State>
						{
							state.awayTeam.players[state.gameStatusDTO.currentHitter]
								.plateAppearances
						}
						타석
						{state.awayTeam.players[state.gameStatusDTO.currentHitter].hitCount}
						안타
					</State>
				</Team>
			</>
		) : (
			<>
				<Team>
					<Role>투수</Role>
					<Name>{state.homeTeam.players[0].name}</Name>
					<State>{state.homeTeam.players[0].id}</State>
				</Team>
				<Team>
					<Role>타자</Role>
					<Name>{state.awayTeam.players[0].name}</Name>
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
