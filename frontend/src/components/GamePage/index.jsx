import { useState, useEffect } from 'react';
import useFetch from '../Hook/useFetch';
import API from '../Hook/API';
import GameGeneralInfo from './GameGeneralInfo';
import styled from 'styled-components';
const GamePage = ({ data }) => {
	console.log(data);
	const gameId = data.id;
	const [gameInfo, loading, error] = useFetch('patch', 'initGame', gameId);

	return (
		<>
			{loading ? (
				console.log('Loading...')
			) : (
				<GridBox>
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
					<GameGeneralInfo data={gameInfo}></GameGeneralInfo>
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
