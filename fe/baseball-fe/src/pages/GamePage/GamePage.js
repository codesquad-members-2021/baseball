import { useEffect, useReducer, useContext } from 'react';
import styled from 'styled-components';
import usePolling from 'util/hook/usePolling.js';
import gameReducer from 'util/reducer/gameReducer.js';
import { GameContext, GlobalContext } from 'util/context.js';
import { GameAction } from 'util/action.js';
import API from 'util/API.js';

import { RunnerMode } from 'util/mode.js';
import TeamScore from 'components/TeamScore/TeamScore.js';
import SituationBoard from 'components/SituationBoard/SituationBoard.js';
import CurrentPlayer from 'components/CurrentPlayer/CurrentPlayer.js';
import BroadCast from 'components/BroadCast/BroadCast.js';
import ScorePopup from 'pages/GamePage/ScorePopup';
import PlayerListPopup from 'pages/GamePage/PlayerListPopup.js';
import Popup from 'components/Popup/Popup.js';

const _initialState = {
  mode: null,
  home: null,
  away: null,
  // latestAction: {
  //   result: null,
  //   time: null,
  // },
  pitcher: null,
  batter: null,
  nthBatter: null,
  runners: [],
  ballCount: {
    strike: null,
    ball: null,
    out: null
  },
  halfInning: {
    currentInning: null,
    frame: null
  },
}

/*
  {
    "home_id": 1,
    "away_id": 2,
    "batting_team_id": 1,
    "pitch_result": "strike", // strike, ball, out, hit
    "batter": {
        "player_id": 1,
        "player_name": "김종수",
        "player_uniform_number": 1,
        "is_out": true
    },
    "ball_count": {
        "strike": 1,
        "ball": 1,
        "out": 2
    },
    "runners": [
        {
          playerId: 123,
          mode: 
        }, ...
    ],
    "score": {
        "home_score": 2,
        "away_score": 1
    }
  }
*/

function GamePage() {
  const { globalState } = useContext(GlobalContext);
  const [gameState, gameDispatch] = useReducer(gameReducer, _initialState);
  const { response, error, setPolling } = usePolling({
    URL: API.start({ id: globalState.gameId }),
    delay: 1000,
  });

  useEffect(() => {
    setPolling(true);
  }, []);

  useEffect(() => {
    if (!response) return;

    const mode = getCurrMode(response);

    if (!gameState.mode)
      gameDispatch({
        type: GameAction.START,
        payload: {
          ...response,
          mode
        }
      });
    // TODO: else ..

    if (mode === 'fielding')
      setPolling(false);

  }, [response]);

  useEffect(() => {
    for (let i = 0; i < gameState.runners.length; i++) {
      if (gameState.runners[i].mode !== RunnerMode.SCORE)
        continue;

      gameDispatch({
        type: GameAction.SCORE,
        payload: { isHomeFielding: globalState.home && gameState.mode === 'fielding' } });
      break;
    }
  }, [gameState.runners]);

  useEffect(() => {
    // TODO: POST result
  }, [gameState]);

  const getCurrMode = (data) =>  {
    return globalState.home ? data.home.mode : data.away.mode;
  }

  return (
    <StyledGamePage>
      <GameContext.Provider value={{ gameState, gameDispatch }}>
        {gameState.mode &&
        <>
          <TeamScore className='team-score'/>
          <CurrentPlayer className='current-player'/>
          <SituationBoard className='situation-board'/>
          <BroadCast className='broadcast'/>
          <Popup direction="top"><ScorePopup/></Popup>
          <Popup direction="bottom"><PlayerListPopup/></Popup>
        </>}
      </GameContext.Provider>
    </StyledGamePage>
  )
}

export default GamePage;

const StyledGamePage = styled.div`
  position: relative;
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