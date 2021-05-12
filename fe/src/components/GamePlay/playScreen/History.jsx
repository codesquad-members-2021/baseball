import styled from 'styled-components';
import Board from 'components/GamePlay/playScreen/Board';

const History = () => {
  return (
    <HistoryWrap>
      {/* 아래 보드는 currentPlayer */}
      <Board />
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
