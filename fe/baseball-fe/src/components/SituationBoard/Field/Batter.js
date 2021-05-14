import { useContext, useEffect } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';
import { GameAction } from 'util/action.js';
import { BatterMode } from 'util/mode.js';

import Baseball from 'util/baseball.js';
import runnerBatSvg from 'rsc/runner_bat.svg';
import runnerHitSvg from 'rsc/runner_hit.svg';

function Batter() {
  const { gameState, gameDispatch } = useContext(GameContext);

  useEffect(() => {
    if (gameState.batter.mode !== BatterMode.HIT)
      return;

    setTimeout(() => {
      gameDispatch({ type: GameAction.RUN_START, payload: { hitBase: Baseball.generateHitBase() } });
    }, 500);
  }, [gameState.batter.mode]);

  return (
    <StyledBatter
      // className={gameState.batter?.mode}
    >
      {gameState.batter?.mode === BatterMode.HIT ? 
        <img src={runnerHitSvg} alg='batter hit'/> :
        <img src={runnerBatSvg} alt='batter bat'/>}
    </StyledBatter>
  );
}

export default Batter;

const StyledBatter = styled.div`
  width: 3rem;
  height: 3rem;
  position: absolute;
  right: 0;
  top: 100%;
  transform: rotate(-135deg);

  /* &.hit {
    background-color: yellowgreen;
  } */
`;
