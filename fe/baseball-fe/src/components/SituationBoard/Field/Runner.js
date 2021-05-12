import { useState, useEffect, useContext, useReducer } from 'react';
import styled, { keyframes } from 'styled-components';
import { GlobalContext, GameContext } from 'util/context.js';
import runnerReducer from 'util/reducer/runnerReducer.js';
import { GameAction, RunnerAction } from 'util/action.js';

function Runner({ runnerIdx, onRunEnd }) {
  const { globalState } = useContext(GlobalContext);
  const { gameState, gameDispatch } = useContext(GameContext);


  const handleAnimationEnd = () => {
    gameDispatch({ type: GameAction.RUN_END, payload: { runnerIdx }});
    onRunEnd();
  }

  return (
    <StyledRunner
      className={gameState.runners[runnerIdx].mode}
      onAnimationEnd={handleAnimationEnd}>
    </StyledRunner>
  );
}

export default Runner;

const RunAnimation = (fromRight, fromTop, toRight, toTop) => keyframes`
  from {
    right: ${fromRight};
    top: ${fromTop};
  }

  to {
    right: ${toRight};
    top: ${toTop};
  }
`;

const StyledRunner = styled.div`
  width: 4rem;
  height: 4rem;
  position: absolute;
  transform: rotate(-45deg);

  &.run-to-home, &.run-to-first, &.run-to-second, &.run-to-third {
    background-color: yellow;
  }

  &.stay-to-first, &.stay-to-second, &.stay-to-third {
    background-color: blue;
  }

  &.run-to-home {
    animation: ${RunAnimation('calc(100% - 2rem)', 'calc(100% - 2rem)', 0, '100%')} 1.5s linear;
  }

  &.run-to-first {
    animation: ${RunAnimation(0, '100%', '-2rem', '-2rem')} 1.5s linear;
  }

  &.stay-to-first {
    right: -2rem;
    top: -2rem;
  }

  &.run-to-second {
    animation: ${RunAnimation('-2rem', '-2rem', 'calc(100% - 2rem)', '-2rem')} 1.5s linear;
  }

  &.stay-to-second {
    right: calc(100% - 2rem);
    top: -2rem;
  }

  &.run-to-third {
    animation: ${RunAnimation('calc(100% - 2rem)', '-2rem', 'calc(100% - 2rem)', 'calc(100% - 2rem)')} 1.5s linear;
  }

  &.stay-to-third {
    right: calc(100% - 2rem);
    top: calc(100% - 2rem);
  }
`;
