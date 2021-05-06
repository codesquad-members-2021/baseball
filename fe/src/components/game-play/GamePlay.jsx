import styled from 'styled-components';
import Score from './score/Score';
import Player from './player/Player';
import Board from './board/Board';
import Log from './log/Log';

const GamePlay = (props) => (
  <StyleGamePlay>
    <StyleGamePlayGrid>
      <Score></Score>
      <Player></Player>
      <Board></Board>
      <Log></Log>
    </StyleGamePlayGrid>
  </StyleGamePlay>
);

const StyleGamePlay = styled.div``;

const StyleGamePlayGrid = styled.div`
  display: grid;
  grid-template-columns: 3fr 1fr;
  grid-template-rows: 27vh 73vh;
  & > div:nth-child(1), & > div:nth-child(2) {
    border-bottom: 3px solid #bbb;
  }
  & > div:nth-child(1), & > div:nth-child(3) {
    padding: 1.5rem 1.5rem 0 1.5rem;
  }
  & > div:nth-child(2), & > div:nth-child(4) {
    border-left: 3px solid #bbb;
    padding: 1.5rem 2rem 0rem 2rem;
  }
`;

export default GamePlay;