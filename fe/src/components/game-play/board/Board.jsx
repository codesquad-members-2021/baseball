import styled from 'styled-components';
import { useReducer, useEffect } from 'react';
import BallCount from './BallCount';
import Inning from './Inning';
import Screen from './Screen';

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
      newState.strike = 0;
      newState.out++;
      break;
    default:
      throw Error('잘못된 ball-count reducer');
  }
  return newState;
};

const Board = (props) => {
  const [ballCount, ballCountDispatch] = useReducer(ballCountReducer, {
    strike: 0,
    ball: 0,
    out: 0,
  });
  const handleStrike = () => {
    if (ballCount.strike === 2) {
      handleOut();
      //필요한 것들
    } else {
      ballCountDispatch({ type: 'strike' });
    }
  };
  const handleBall = () => {
    if (ballCount.ball === 3) {
      ballCountDispatch({ type: 'safety' });
    } else {
      ballCountDispatch({ type: 'ball' });
    }
  };
  const handleOut = () => {
    if (ballCount.out === 2) {
      ballCountDispatch({ type: 'clear' });
      // 공수교대
      // if(turn)
      // setTurn(false);
      // else
      // setRound(round + 1);
      // setTurn(true);
    } else {
      ballCountDispatch({ type: 'out' });
    }
  };
  const handleSafety = () => {
    ballCountDispatch({ type: 'safety' });
  };

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

const inning = {
  turn: true,
  round: 4,
};
