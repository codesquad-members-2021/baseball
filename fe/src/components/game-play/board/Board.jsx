import styled from 'styled-components';
import { useState, useReducer, useContext, useEffect } from 'react';
import BallCount from './BallCount';
import Inning from './Inning';
import Screen from './Screen';
import { ScoreNBaseContext } from '../GamePlay';
import { fetchPUT } from '../../../util/api.js';

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

const Board = ({ memberListDispatch, inning, setInning, logListDispatch }) => {
  const [ballCount, ballCountDispatch] = useReducer(ballCountReducer, {
    strike: 0,
    ball: 0,
    out: 0,
  });
  const { safetyDispatch } = useContext(ScoreNBaseContext);
  const handleStrike = () => {
    if (ballCount.strike === 2) {
      handleOut();
      //필요한 것들
    } else {
      ballCountDispatch({ type: 'strike' });
      logListDispatch({ type: 'strike', ...ballCount, strike: ballCount.strike + 1 });
    }
  };
  const handleBall = () => {
    if (ballCount.ball === 3) {
      ballCountDispatch({ type: 'safety' });
      logListDispatch({ type: '4ball', end: true });
      memberListDispatch({ type: 'safety', turn: inning.turn });
    } else {
      ballCountDispatch({ type: 'ball' });
      logListDispatch({ type: 'ball', ...ballCount, ball: ballCount.ball + 1 });
    }
  };
  const handleOut = () => {
    if (ballCount.out === 2) {
      ballCountDispatch({ type: 'clear' });
      if (inning.turn) setInning({ ...inning, turn: !inning.turn });
      else setInning({ ...inning, round: inning.round + 1, turn: !inning.turn });
      safetyDispatch({ type: 'clear', turn: inning.turn });
      logListDispatch({ type: 'clear' });
    } else {
      logListDispatch({ type: 'out', end: true });
      ballCountDispatch({ type: 'out' });
    }
    // 멤버 아웃 1, 타석 1 증가
    memberListDispatch({ type: 'out', turn: inning.turn });
  };
  const handleSafety = (power) => {
    ballCountDispatch({ type: 'safety' });
    // 멤버 안타 1, 타석 1 증가
    memberListDispatch({ type: 'safety', turn: inning.turn });
    logListDispatch({ type: 'safety', end: true });
    safetyDispatch({ turn: inning.turn, power });
  };

  useEffect(() => {
    return () => fetchPUT(inning);
  }, [inning]);

  return (
    <StyledBoard>
      <BallCount ballCount={ballCount}></BallCount>
      <Screen {...{ handleStrike, handleBall, handleSafety }}></Screen>
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
