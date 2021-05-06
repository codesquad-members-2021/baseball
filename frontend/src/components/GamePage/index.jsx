import { useState, useEffect } from 'react';
import API from '../Hook/API';
import GameGeneralInfo from './GameGeneralInfo';
import styled from 'styled-components';
const GamePage = ({ data }) => {
	const gameId = data.id;
	const [initState, setInitState] = useState([]);
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(false);

	useEffect(() => {
		const getInitScore = async () => {
			setLoading(true);
			try {
				const { gameStatus } = await API.get.initData('/' + gameId);
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
				<GridBox>
					<GameGeneralInfo data={initState}></GameGeneralInfo>
					<div>2</div>
					<div>3</div>
					<div>4</div>
				</GridBox>
			)}
		</>
	);
};

const GridBox = styled.div`
	display: grid;
	grid-template-colums: 3fr 1fr;
	grid-template-rows: 1fr 3fr;
	grid-gap: 5px;
	border: 1px solid blue;
`;
export default GamePage;
