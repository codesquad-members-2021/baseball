import { useContext } from 'react';

import { gamePlayContext } from 'components/GamePlay/GamePlay';

const Hitter = () => {
  const { isAttacking, homeCurrentPlayerState, awayCurrentPlayerState } =
    useContext(gamePlayContext);

  const { playerName, turn, hits } = isAttacking
    ? awayCurrentPlayerState
    : homeCurrentPlayerState;

  return (
    <>
      <span>{playerName}</span>
      <span>
        {turn}타석 {hits}안타
      </span>
    </>
  );
};

export default Hitter;
