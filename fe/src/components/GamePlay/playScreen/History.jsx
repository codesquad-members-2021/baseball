import { useState } from 'react';
import styled from 'styled-components';
import Board from 'components/GamePlay/playScreen/Board';
import { v4 as uuidv4 } from 'uuid';

const History = () => {
  const [homePrevPlayer, setHomePrevPlayer] = useState({});
  const [awayPrevPlayer, setAwayPrevPlayer] = useState([{}]);
  const [currentPlayer, setCurrentPlayer] = useState({});

  return (
    <HistoryWrap>
      <Board currentPlayer={currentPlayer} />
      {/* {homePrevPlayer.map((player) => (
        <Board key={uuidv4()} player={player} />
      ))} */}
    </HistoryWrap>
  );
};

export default History;

const HistoryWrap = styled.section`
  background-color: ${({ theme }) => theme.colors.black};
  width: 30%;
`;
