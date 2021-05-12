import { useContext, useEffect } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';
import { GameAction } from 'util/action.js';
import { BatterMode } from 'util/mode.js';

import Baseball from 'util/baseball.js';
import runnerBatSvg from 'rsc/runner_bat.svg';

function Batter() {
  const { gameState, gameDispatch } = useContext(GameContext);

  useEffect(() => {
    if (gameState.batter.mode !== BatterMode.HIT)
      return;

    // setTimeout(() => {
      gameDispatch({ type: GameAction.RUN_START, payload: { hitBase: Baseball.generateHitBase() } });
    // }, 300);
  }, [gameState.batter.mode]);

  return (
    <StyledBatter className={gameState.batter?.mode}>
      <img src={runnerBatSvg} alt='batter'/>
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

  &.hit {
    background-color: yellowgreen;
  }
`;
