import styled from 'styled-components';

const Game = ({ game }) => {
  return (
    <GameLi>
      <Wrapper>
        <Team>{game.home_team.name}</Team>
        <Versus>vs</Versus>
        <Team>{game.away_team.name}</Team>
      </Wrapper>
    </GameLi>
  );
};

const GameLi = styled.li`
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: ${({ theme }) => theme.colors.lightGray};
  width: 100%;
  height: 120px;
  border-radius: 6px;
  margin-bottom: 10px;
`;

const Wrapper = styled.div`
  display: flex;
`;

const Team = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XL};

  &:hover {
    cursor: pointer;
    color: ${({ theme }) => theme.colors.green};
  }
`;

const Versus = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XL};
  margin: 0 40px;
`;
export default Game;
