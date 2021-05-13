import { useContext, useState, useEffect } from 'react';
import { gamePlayContext } from 'components/GamePlay/GamePlay';

const Pitcher = () => {
  const {
    ballCountState: { count },
    pitcherName,
    isAttacking,
    saveDataState,
  } = useContext(gamePlayContext);

  const pitchCount = isAttacking
    ? count + saveDataState.awayCount
    : count + saveDataState.homeCount;

  return (
    <>
      <span>{pitcherName}</span>
      <span>#{pitchCount}</span>
    </>
  );
};

export default Pitcher;
