import styled from 'styled-components';
import BallCount from './BallCount';
import Inning from './Inning';
import Screen from './Screen';

const Board = (props) => (
  <StyledBoard>
    <BallCount ballCount={ ballCount}></BallCount>
    <Screen></Screen>
    <Inning inning={inning} isHome = {isHome}></Inning>
  </StyledBoard>
);

const StyledBoard = styled.div`
  display: grid;
  grid-template-columns: 10rem 1fr 10rem;
`;

export default Board;

const isHome = true;

const inning = {
  turn: true,
  round: 4
}

const ballCount = {
  strike: 2,
  ball: 3,
  out: 2
};

