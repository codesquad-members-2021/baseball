import useFetch from '../Hook/useFetch';
import { useState, useEffect } from 'react';
import styled from 'styled-components';
import GameGeneralInfo from './GameGeneralInfo';
import GamePlayers from './GamePlayers';
import GameFieldArea from './GameFieldArea';
import GameLog from './GameLog';
import GamePlayersList from './GamePlayersList';
import GameDetailScore from './GameDetailScore';
import useSlide from '../Hook/useSlide';

const GameGrid = ({ data, type }) => {
  const gameId = data.id;
  const [gameInfo, loading, error] = useFetch('get', 'initGame', gameId);

  return (
    <>
      {loading ? (
        console.log('Loading...')
      ) : (
        <GridBox>
          <GameGeneralInfo data={gameInfo}></GameGeneralInfo>
          <GamePlayers />
          <GameFieldArea type={type} />
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

export default GameGrid;
