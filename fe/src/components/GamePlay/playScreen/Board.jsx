<<<<<<< HEAD
import { v4 as uuidv4 } from 'uuid';
import styled from 'styled-components';
import BoardItem from 'components/GamePlay/playScreen/BoardItem';

const Board = ({
  playerName,
  turn,
  uniformNumber,
  history,
  hits,
  previousAction,
}) => {
=======
import styled from 'styled-components';
import BoardItem from 'components/GamePlay/playScreen/BoardItem';

const Board = () => {
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
  return (
    <BoardWrap>
      <div>
        <h3>
<<<<<<< HEAD
          {uniformNumber}번 타자 {playerName}
        </h3>
      </div>
      {previousAction}
      <BoardLists>
        {history.length !== 0 &&
          history.map((stat, i) => (
            <BoardItem key={uuidv4()} {...{ ...stat, playerName }} idx={i} />
          ))}
=======
          {7}번 타자 {'류현진'}
        </h3>
      </div>
      {'안타'}
      <BoardLists>
        <BoardItem />
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
      </BoardLists>
    </BoardWrap>
  );
};

export default Board;

const BoardWrap = styled.ul`
  padding: 2rem;
  color: ${({ theme }) => theme.colors.orange};

  h3 {
    font-size: ${({ theme }) => `${theme.fontSizes.TITLES}rem`};
    font-weight: ${({ theme }) => theme.weights.LARGE};
  }
`;

const BoardLists = styled.ul`
  display: flex;
  flex-direction: column-reverse;

  margin-top: 1rem;
  color: ${({ theme }) => theme.colors.white};
`;
