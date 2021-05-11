import styled from 'styled-components';
import BoardItem from 'components/GamePlay/playScreen/BoardItem';

const Board = () => {
  return (
    <BoardWrap>
      <div>
        <h3>
          {7}번 타자 {'류현진'}
        </h3>
      </div>
      {'안타'}
      <BoardLists>
        <BoardItem />
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
