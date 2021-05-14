import { useContext } from 'react';
import styled from 'styled-components';

import { gamePlayContext } from 'components/GamePlay/GamePlay';

const Pitcher = () => {
  const {
    ballCountState: { homeCount, awayCount },
    pitcherName,
    isAttacking,
  } = useContext(gamePlayContext);

  const pitchCount = isAttacking ? awayCount : homeCount;

  return (
    <PitcherWrap>
      <span>{pitcherName}</span>
      <span>#{pitchCount}</span>
    </PitcherWrap>
  );
};

export default Pitcher;

const PitcherWrap = styled.div`
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
`;
