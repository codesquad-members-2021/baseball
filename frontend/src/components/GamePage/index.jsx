import useFetch from '../Hook/useFetch';
import GameGeneralInfo from './GameGeneralInfo';
import GamePlayers from './GamePlayers';
import styled from 'styled-components';
import GameLog from './GameLog';
const GamePage = ({ data }) => {
	const gameId = data.id;
	const [gameInfo, loading, error] = useFetch('patch', 'initGame', gameId);

	return (
		<>
			{loading ? (
				console.log('Loading...')
			) : (
				<GridBox>
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
					<GamePlayers />
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
					<GameLog data={gameInfo}></GameLog>
				</GridBox>
			)}
		</>
	);
};

const GridBox = styled.div`
	width: 100vw;
	height: 100vh;
	display: grid;
	grid-template-columns: 80% 20%;
	grid-template-rows: 20% 80%;
	grid-gap: 5px;
`;
export default GamePage;
