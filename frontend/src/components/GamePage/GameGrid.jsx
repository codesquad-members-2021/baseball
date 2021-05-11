import useFetch from '../Hook/useFetch';
import {
	useState,
	useEffect,
	createContext,
	useContext,
	useReducer,
} from 'react';
import styled from 'styled-components';
import GameGeneralInfo from './GameGeneralInfo';
import GamePlayers from './GamePlayers';
import GameFieldArea from './GameFieldArea';
import GameLog from './GameLog';
import GamePlayersList from './GamePlayersList';
import GameDetailScore from './GameDetailScore';
import useSlide from '../Hook/useSlide';
import { GameStateContext } from '../GameContext';
const GameGrid = () => {
	const state = useContext(GameStateContext);
	console.log(state);
	return (
		<>
			{/* {loading ? (
				console.log('Loading...')
			) : (
				<GridBox>
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
					<GamePlayers />
					<GameFieldArea type={type} />
					<GameLog data={gameInfo}></GameLog>
				</GridBox>
			)} */}
		</>
	);
};

const GridBox = styled.div`
	display: grid;
	grid-template-columns: 80% 20%;
	grid-template-rows: 20% 80%;
	box-sizing: border-box;
`;

export default GameGrid;
