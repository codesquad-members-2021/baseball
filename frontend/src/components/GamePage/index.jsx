import { useState, useEffect } from 'react';
import API from '../Hook/API';
import GameGeneralInfo from './GameGeneralInfo';

const GamePage = () => {
	const [initState, setInitState] = useState([]);
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(false);

	useEffect(() => {
		const getInitScore = async () => {
			setLoading(true);
			try {
				const { gameStatus } = await API.get.initData();
				setInitState(gameStatus);
				setLoading(false);
			} catch (err) {
				console.error(err);
				setError(true); //error처리
			}
		};
		getInitScore();
	}, []);
	return (
		<>
			{loading ? (
				console.log('Loading...')
			) : (
				<GameGeneralInfo data={initState}></GameGeneralInfo>
			)}
		</>
	);
};

export default GamePage;
