import { useContext } from 'react';
import styled from 'styled-components';
import Board from 'components/GamePlay/playScreen/Board';
import { gamePlayContext } from 'components/GamePlay/GamePlay';

const History = () => {
  const { homeCurrentPlayerState, awayCurrentPlayerState, isAttacking } =
    useContext(gamePlayContext);

  const playerStates = isAttacking
    ? awayCurrentPlayerState
    : homeCurrentPlayerState;
  // const {playerName, uniformNumber,turn,hits,hisory} = playerStates
  return (
    <HistoryWrap>
     
      <Board {...{ ...playerStates }} />

      {/* {homePrevPlayer.map((player) => (
        <Board key={uuidv4()} player={player} />
      ))} */}
    </HistoryWrap>
  );
};

export default History;

const HistoryWrap = styled.section`
  background-color: ${({ theme }) => theme.colors.black};
  width: 20%;
`;
