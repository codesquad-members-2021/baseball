import { useContext } from 'react';
import styled, { keyframes } from 'styled-components';
import { GameContext } from 'util/context.js';
import { GameAction } from 'util/action.js';

import runnerRunSvg from 'rsc/runner_run.svg';
import runnerStandSvg from 'rsc/runner_stand.svg';

function Runner({ runnerIdx, onRunEnd }) {
  const { gameState, gameDispatch } = useContext(GameContext);

  const isRun = (mode) => {
    if (mode === 'run-to-first' || 'run-to-second' || 'run-to-third' || 'run-to-home') return true;
    return false;
  };

  const handleAnimationEnd = () => {
    gameDispatch({ type: GameAction.RUN_END, payload: { runnerIdx }});
    onRunEnd();
  }

  return (
    <StyledRunner
      className={gameState.runners[runnerIdx].mode}
      onAnimationEnd={handleAnimationEnd}>
      {isRun(gameState.runners[runnerIdx].mode) ?
        <img src={runnerRunSvg} alt='runner run'/> :
        <img src={runnerStandSvg} alg='runner stand'/>}
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
