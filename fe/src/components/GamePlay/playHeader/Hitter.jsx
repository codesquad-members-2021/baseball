import { useContext } from 'react';
import { gamePlayContext } from 'components/GamePlay/GamePlay';

const Hitter = ({ type }) => {
  const { isAttacking, homeCurrentPlayerState, awayCurrentPlayerState } =
    useContext(gamePlayContext);

  return (
    <>
      <span>{homeCurrentPlayerState.playerName}</span>
      <span>
        {homeCurrentPlayerState.turn}타석 {homeCurrentPlayerState.hit}안타
      </span>
    </>
  );
};

export default Hitter;
