import { useRef, useState, useEffect, useReducer } from 'react';
import styled from 'styled-components';
import runnerReducer from 'util/reducer/runnerReducer.js';
import { RunnerAction } from 'util/action.js';

import runnerBatSvg from 'rsc/runner_bat.svg';

const _initialState = {
  mode: RunnerAction.BAT,
  modeSvg: runnerBatSvg,
  runFrom: null,
  runTo: null,
  base: 'home'
}

function Runner() {
  const [runnerState, runnerDispatch] = useReducer(runnerReducer, _initialState);
  const runnerRef = useRef();

  useEffect(() => {
    setTimeout(() => {
      runnerDispatch({ type: RunnerAction.RUN });
    }, 2000);
  }, []);

  return (
    <StyledRunner ref={runnerRef} className={runnerState.base}>
      <img src={runnerState.modeSvg} alt='runner mode'/>
    </StyledRunner>
  );
}

export default Runner;

const StyledRunner = styled.div`
  width: 4rem;
  height: 4rem;
  position: absolute;
  transition: position 5s linear;

  &.home {
    right: 0;
    bottom: 0;
  }

  &.first {

  }

  &.second {

  }

  &.third {
    
  }
`;
