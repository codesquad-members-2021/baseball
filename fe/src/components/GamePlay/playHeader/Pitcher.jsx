import { useContext, useState, useEffect } from 'react';
import { gamePlayContext } from 'components/GamePlay/GamePlay';

const Pitcher = () => {
  const {
    ballCountState: { homeCount, awayCount },
    pitcherName,
    isAttacking,
  } = useContext(gamePlayContext);

  const pitchCount = isAttacking ? awayCount : homeCount;

  return (
    <>
      <span>{pitcherName}</span>
      <span>#{pitchCount}</span>
    </>
  );
};

export default Pitcher;
