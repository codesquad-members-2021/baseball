import { useHistory } from 'react-router';
import styled from 'styled-components';

const Game = ({ game }) => {
  const history = useHistory();
  const handleClickTeam = () => history.push('/play-screen');

  return (
    <GameLi>
      <Wrapper>
        <Team onClick={handleClickTeam}>{game.home_team.name}</Team>
        <Versus>vs</Versus>
        <Team onClick={handleClickTeam}>{game.away_team.name}</Team>
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
  height: 100px;
  border-radius: 14px;
  margin-bottom: 10px;
`;

const Wrapper = styled.div`
  display: flex;
`;

const Team = styled.div`
  /* font-size: ${({ theme }) => theme.fontSizes.XL}; */
  font-size: 32px;
  font-weight: bold;
  color: ${({ theme }) => theme.colors.darkGray};

  &:hover {
    cursor: pointer;
    color: ${({ theme }) => theme.colors.green};
  }
`;

const Versus = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XL};
  margin: 0 40px;
  display: flex;
  align-items: center;
  font-weight: bolder;
  color: ${({ theme }) => theme.colors.gray};
`;
export default Game;
