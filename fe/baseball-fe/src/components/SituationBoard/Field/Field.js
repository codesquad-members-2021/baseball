import { useState, useEffect, useContext } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';
import { GameAction } from 'util/action.js';

import Runner from './Runner.js';
import Batter from './Batter.js';
import { BatterMode } from 'util/mode.js';

function Field() {
  const { gameState, gameDispatch } = useContext(GameContext);
  const [runEndCnt, setRunEndCnt] = useState(0);

  useEffect(() => {
    // console.log(runEndCnt, gameState.runners.length);
    if (runEndCnt < gameState.runners.length) return;
  
    gameDispatch({ type: GameAction.NEXT_BATTER });
    setRunEndCnt(0);
  }, [runEndCnt]);

  const handleRunEnd = () => {
    setRunEndCnt(v => v + 1);
  }

  const renderRunners = () => {
    return gameState.runners.map((runner, idx) =>
      <Runner key={runner.playerId} runnerIdx={idx} onRunEnd={handleRunEnd}/>
    );
  }

  return (
    <StyledField>
      <InField>
        <Base className='home'/>
        <Base className='first'/>
        <Base className='second'/>
        <Base className='third'/>
        {gameState.batter.mode !== BatterMode.RUN && <Batter/>}
        {gameState.runners.length && renderRunners()}
      </InField>
    </StyledField>
  );
}

export default Field;

const StyledField = styled.div`
  width: 500px;
  height: 500px;
  display: flex;
  justify-content: center;
`;

const InField = styled.div`
  width: 16rem;
  height: 16rem;
  border: 3px solid #CCCCCC;
  position: relative;
  transform: rotate(45deg);
`;

const Base = styled.div`
  width: 3rem;
  height: 3rem;
  position: absolute;
  background-color: #CCCCCC;

  &.first {
    right: -1.5rem;
    top: -1.5rem;
  }

  &.second {
    left: -1.5rem;
    top: -1.5rem;
  }

  &.third {
    left: -1.5rem;
    bottom: -1.5rem;
  }

  &.home {
    width: 2rem;
    height: 2rem;
    display: inline-block;
    position: absolute;
    right: 0;
    bottom: 0;
  }
  
  &.home:before {
    border: ${Math.sqrt(8) / 2}rem solid #CCCCCC;
    content: "";
    position: absolute;
    right: 0;
    top: 0;
    transform-origin: top right;
    transform: rotate(-45deg);
  }
`;


