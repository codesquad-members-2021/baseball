import styled from 'styled-components';
import { useState, useReducer, useContext, useEffect } from 'react';
import BallCount from './BallCount';
import Inning from './Inning';
import Screen from './Screen';
import { GameIdContext, ScoreNBaseContext } from '../GamePlay';
import { fetchPUT, fetchPOST } from '../../../util/api.js';
import useFetch from '../../../hooks/useFetch';

const URL = 'http://52.78.184.142';

const ballCountReducer = (state, action) => {
  let newState = { ...state };
  switch (action.type) {
    case 'strike':
      newState.strike++;
      break;
    case 'ball':
      newState.ball++;
      break;
    case 'safety':
      newState = { strike: 0, ball: 0, out: newState.out };
      break;
    case 'clear':
      newState = { strike: 0, ball: 0, out: 0 };
      break;
    case 'out':
      newState.ball = 0;
      newState.strike = 0;
      newState.out++;
      break;
    default:
      throw Error('잘못된 ball-count reducer');
  }
  return newState;
};

const Board = ({
  memberListDispatch,
  inning,
  setInning,
  logListDispatch,
  game_id,
  teamName,
  teamId,
  selectTeam,
  memberList,
}) => {
  const [ballCount, ballCountDispatch] = useReducer(ballCountReducer, {
    strike: 0,
    ball: 0,
    out: 0,
  });
  const { score, base, safetyDispatch } = useContext(ScoreNBaseContext);
  const { gameID } = useContext(GameIdContext);

  const getPlayerId = () => memberList[inning.turn ? 'home' : 'away'].find((v) => v.status)?.id;

  const currentRoundScore = {
    game_id: gameID,
    home: score.home[inning.round - 1] + inning.turn,
    away: !inning.turn ? score.away[inning.round - 1] + 1 : null,
    round: inning.round,
  };

  const handleStrike = () => {
    if (ballCount.strike === 2) {
      handleOut();
    } else {
      ballCountDispatch({ type: 'strike' });
      logListDispatch({ type: 'strike', ...ballCount, strike: ballCount.strike + 1 });
    }
  };
  const handleBall = () => {
    if (ballCount.ball === 3) {
      if (base[3]) {
        //4번 API {"game_id": 7,"home": 1,"away": 2, "round": 3} 모든정보 컨텍스트로
        fetchPUT(`${URL}/games/${gameID}`, currentRoundScore);
      }
      const playerId = getPlayerId();
      fetchPUT(`${URL}/players/${playerId}`, { game_id: gameID, at_bat: true });
      ballCountDispatch({ type: 'safety' });
      logListDispatch({ type: '4ball', end: true });
      memberListDispatch({ type: 'safety', turn: inning.turn, game_id });
    } else {
      ballCountDispatch({ type: 'ball' });
      logListDispatch({ type: 'ball', ...ballCount, ball: ballCount.ball + 1 });
    }
  };
  const handleOut = () => {
    const playerId = getPlayerId();
    if (ballCount.out === 2) {
      //7번 API { "game_id": 6, "team_id":1, "round":3, "at_bat": 3 } ??타자를 번호를 보내는거네???
      // 여기에 공수교대
      //
      fetchPOST(`${URL}/games/${gameID}`, {
        game_id: gameID,
        round: inning.round,
        player_id: playerId,
        team_id: inning.turn ? teamId.home : teamId.away,
      });
      ballCountDispatch({ type: 'clear' });
      if (inning.turn) setInning({ ...inning, turn: !inning.turn });
      else setInning({ ...inning, round: inning.round + 1, turn: !inning.turn });
      safetyDispatch({ type: 'clear', turn: !inning.turn });
      logListDispatch({ type: 'clear' });
    } else {
      fetchPUT(`${URL}/players/${playerId}`, { game_id: gameID, at_bat: false });
      logListDispatch({ type: 'out', end: true });
      ballCountDispatch({ type: 'out' });
    }
    // 멤버 아웃 1, 타석 1 증가
    memberListDispatch({ type: 'out', turn: inning.turn, game_id });
  };
  const handleSafety = () => {
    if (base[3]) {
      //4번 API {"game_id": 7,"home": 1,"away": 2, "round": 3} 모든정보 컨텍스트로
      fetchPUT(`${URL}/games/${gameID}`, currentRoundScore);
    }
    const playerId = getPlayerId();
    fetchPUT(`${URL}/players/${playerId}`, { game_id: gameID, at_bat: true });
    ballCountDispatch({ type: 'safety' });
    // 멤버 안타 1, 타석 1 증가
    memberListDispatch({ type: 'safety', turn: inning.turn, game_id });
    logListDispatch({ type: 'safety', end: true });
  };

  // useEffect(() => {
  //   return () => fetchPUT(inning);
  // }, [inning]);

  return (
    <StyledBoard>
      <BallCount ballCount={ballCount}></BallCount>
      <Screen
        {...{ handleStrike, handleBall, handleSafety, ballCount, teamName, selectTeam }}
        turn={inning.turn}
      ></Screen>
      <Inning inning={inning} isHome={isHome}></Inning>
    </StyledBoard>
  );
};

const StyledBoard = styled.div`
  display: grid;
  grid-template-columns: 10rem 1fr 10rem;
`;

export default Board;

const isHome = true;
