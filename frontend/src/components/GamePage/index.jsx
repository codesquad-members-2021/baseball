import { useState, useEffect } from 'react';
import GamePlayersList from './GamePlayersList';
import GameDetailScore from './GameDetailScore';
import GameGrid from './GameGrid';

const GamePage = ({ data, type }) => {
	const [upState, setUpState] = useState(false);
	const [downState, setDownState] = useState(false);

	useEffect(() => {
		const handle = (event) => {
			console.log(event, upState, downState);
			const { clientY } = event;
			if (clientY < 5) {
				setUpState(true);
				console.log('UP');
			} else if (clientY > 750) {
				setDownState(true);
				console.log('Down');
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
		<>
			{upState && <GameDetailScore />}
			<GameGrid data={data} type={type} />
			{downState && <GamePlayersList />}
		</>
	);
};

export default GamePage;
