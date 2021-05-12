import { useReducer, useState } from 'react';
import styled from 'styled-components';

const hitterAction = {
  HIT: 'HIT',
  DOUBLE: 'DOUBLE',
  TRIPLE: 'TRIPLE',
  HR: 'HR',
};

const initialBaseState = {
  first: 0,
  second: 0,
  third: 0,
};

const hitterReducer = (state, action) => {
  console.log(state, action);
  switch (action.type) {
    case hitterAction.HIT:
      return console.log(state);
    case hitterAction.DOUBLE:
      return;
    case hitterAction.TRIPLE:
      return;
    case hitterAction.HR:
      return;
    default:
      throw new Error();
  }
};

const Hitter = () => {
  const initialHitterAction = 0;
  const [baseState, setBaseState] = useState(initialBaseState);
  const [hitterAction, hitterActionDispatch] = useReducer(
    hitterReducer,
    initialHitterAction
  );

  const handleClickHitter = () => {
    console.log('hit');
    hitterActionDispatch({ type: 'HIT' });
  };
  return <HitterStyle onClick={handleClickHitter}>Hitter</HitterStyle>;
};

export default Hitter;

const HitterStyle = styled.button`
  position: absolute;
  width: 100px;
  height: 100px;
  border: none;
  cursor: pointer;
  z-index: 9999;
`;
