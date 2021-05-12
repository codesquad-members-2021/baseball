import styled from 'styled-components';
import GameGeneralInfo from './GameGeneralInfo';
import GamePlayers from './GamePlayers';
import GameFieldArea from './GameFieldArea';
import GameLog from './GameLog';
const GameGrid = ({ type, id }) => {
	return (
		<GridBox>
			<GameGeneralInfo type={type} />
			<GamePlayers />
			<GameFieldArea type={type} id={id} />
			<GameLog></GameLog>
		</GridBox>
	);
};

const GridBox = styled.div`
	display: grid;
	grid-template-columns: 80% 20%;
	grid-template-rows: 20% 80%;
	box-sizing: border-box;
`;

export default GameGrid;
