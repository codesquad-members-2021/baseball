import { useState, useEffect } from 'react';
import GamePlayersList from './GamePlayersList';
import GameDetailScore from './GameDetailScore';
import GameGrid from './GameGrid';
import useFetch from '../Hook/useFetch';
import { GameProvider } from '../GameContext';
const GamePage = ({ data, type }) => {
	const id = data.id;
	const [gameData, loadingState, error] = useFetch('get', 'initGame', id);
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
		!loadingState && (
			<GameProvider gameData={gameData}>
				{upState && <GameDetailScore />}
				<GameGrid type={type} id={id} />
				{downState && <GamePlayersList />}
			</GameProvider>
		)
	);
};

export default GamePage;
