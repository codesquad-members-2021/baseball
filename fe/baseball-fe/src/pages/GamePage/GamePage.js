import React, { useEffect, useReducer, useContext } from 'react';
import styled from 'styled-components';
import gameReducer from 'util/reducer/gameReducer.js';
import { GameContext, GlobalContext } from 'util/context.js';

import TeamScore from 'components/TeamScore/TeamScore.js';
import SituationBoard from 'components/SituationBoard/SituationBoard.js';
import CurrentPlayer from 'components/CurrentPlayer/CurrentPlayer.js';
import BroadCast from 'components/BroadCast/BroadCast.js';

const _initialState = {
  mode: '',
  awayTeam: 'abc',
  homeTeam: 'def',
  awayScore: 0,
  homeScore: 0,
  currPitcher: null,
  currHitter: null,


}

function GamePage() {
  const { globalState } = useContext(GlobalContext);
  const [gameState, gameDispatch] = useReducer(gameReducer, _initialState);
  
  useEffect(() => {
    // TODO: fetch data
  }, []);

  return (
    <StyledGamePage>
      <GameContext.Provider value={{ gameState, gameDispatch }}>
        <TeamScore className='team-score' playTeam={globalState.playTeam}/>
        <CurrentPlayer className='current-player'/>
        <SituationBoard className='situation-board'/>
        <BroadCast className='broadcast'/>
      </GameContext.Provider>
    </StyledGamePage>
  )
}

export default GamePage;

const StyledGamePage = styled.div`
  width: 100%;
  height: 100%;
  box-shadow: 0 0 0 1px green inset;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: repeat(4, 1fr);
  grid-gap: 2px;

  .team-score {
    grid-column: 1 / 4;
    grid-row: 1;
  }

  .current-player {
    grid-column: 4 / -1;
    grid-row: 1;
  }

  .situation-board {
    grid-column: 1 / 4;
    grid-row: 2 / -1;
  }

  .broadcast {
    grid-column: 4 / -1;
    grid-row: 2 / -1;
  }
`;