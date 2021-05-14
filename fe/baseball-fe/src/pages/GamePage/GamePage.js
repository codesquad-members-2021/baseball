import styled from 'styled-components';
import { useState, useEffect, useReducer, useContext } from 'react';
import usePolling from 'util/hook/usePolling.js';
import gameReducer from 'util/reducer/gameReducer.js';
// import recordReducer from 'util/reducer/recordReducer.js';
import { GameContext, GlobalContext } from 'util/context.js';
import { GameAction } from 'util/action.js';
import API from 'util/API.js';

import { RunnerMode } from 'util/mode.js';
import Baseball from 'util/baseball.js';
import TeamScore from 'components/TeamScore/TeamScore.js';
import SituationBoard from 'components/SituationBoard/SituationBoard.js';
import CurrentPlayer from 'components/CurrentPlayer/CurrentPlayer.js';
import BroadCast from 'components/BroadCast/BroadCast.js';
import ScorePopup from 'pages/GamePage/ScorePopup';
import PlayerListPopup from 'pages/GamePage/PlayerListPopup.js';
import Popup from 'components/Popup/Popup.js';

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
  const [gameState, gameDispatch] = useReducer(gameReducer, globalState.initialGameState);
  const [records, setRecords] = useState([]);
  const { response: responsePitch, setPolling: setPitchPolling } = usePolling({
    URL: API.pitchResult({ gameId: globalState.gameId, userId: globalState.userId }),
  });
  const { response: responseRecord, setPolling: setRecordPolling } = usePolling({
    URL: API.batterRecord({ gameId: globalState.gameId, userId: globalState.userId }),
  })

  useEffect(() => {
    if (gameState.mode === 'FIELDING') {
      setPitchPolling(false);
      setRecordPolling(false);
    } else if (gameState.mode === 'BATTING') {
      setPitchPolling(true);
      setRecordPolling(true);
    }
  }, [gameState.mode]);

  useEffect(() => {
    if (!responsePitch || responsePitch.home_id === null)
      return;

    gameDispatch({ type: GameAction.UPDATE, payload: { ...responsePitch, home: globalState.home }});
  }, [responsePitch]);

  useEffect(() => {
    if (!responseRecord)
      return;

    setRecords(responseRecord);
  }, [responseRecord]);

  useEffect(() => {
    for (let i = 0; i < gameState.runners.length; i++) {
      if (gameState.runners[i].mode !== RunnerMode.SCORE)
        continue;

      gameDispatch({
        type: GameAction.SCORE,
        payload: { isHomeFielding: globalState.home && gameState.mode === 'FIELDING' } });
      break;
    }
  }, [gameState.runners]);
  
  useEffect(() => {
    if (!gameState.additionalRecord)
      return;

    const newRecords = [...records, { ...gameState.additionalRecord }];
    setRecords(newRecords);

    fetch(API.batterRecord({ gameId: globalState.gameId, userId: globalState.userId }),
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(newRecords)
      }
    );
    gameDispatch({ type: GameAction.ADDITIONAL_RECORD_END });
  }, [gameState.additionalRecord]);

  useEffect(() => {
    if (!gameState.needToPost || gameState.mode === 'BATTING')
      return;

    if (gameState.halfInningEnd) {
      fetch(API.halfInning({ gameId: globalState.gameId, userId: globalState.userId }),
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(Baseball.organizeResult(gameState, globalState.home))
        }
      );
    } else {
      fetch(API.pitch({ gameId: globalState.gameId, userId: globalState.userId }),
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(Baseball.organizeResult(gameState, globalState.home))
        }
      );
    }

    gameDispatch({ type: GameAction.NEED_TO_POST_END });
  }, [gameState.needToPost]);

  return (
    <StyledGamePage>
        <GameContext.Provider value={{ gameState, gameDispatch, records, setRecords }}>
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
  /* box-shadow: 0 0 0 1px green inset; */
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
