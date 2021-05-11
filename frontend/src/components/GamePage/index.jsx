import {
	useState,
	useEffect,
	createContext,
	useContext,
	useReducer,
} from 'react';
import GamePlayersList from './GamePlayersList';
import GameDetailScore from './GameDetailScore';
import GameGrid from './GameGrid';
import useFetch from '../Hook/useFetch';
import { GameProvider } from '../GameContext';
const GamePage = ({ data, type }) => {
	const [gameData, loadingState, error] = useFetch(
		'patch',
		'initGame',
		data.id,
	);
	console.log(gameData);
	const [upState, setUpState] = useState(false);
	const [downState, setDownState] = useState(false);

	useEffect(() => {
		const handle = (event) => {
			const { clientY } = event;
			if (clientY < 5) {
				setUpState(true);
			} else if (clientY > 750) {
				setDownState(true);
			} else {
				setUpState(false);
				setDownState(false);
			}
		};
		document.addEventListener('mousemove', handle);
		return () => {
			document.removeEventListener('mousemove', handle);
		};
	});

	return (
		<GameProvider value={gameData}>
			{upState && <GameDetailScore />}
			<GameGrid type={type} />
			{downState && <GamePlayersList />}
		</GameProvider>
	);
};

export default GamePage;
