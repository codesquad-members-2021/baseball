import { useHistory } from 'react-router';
import styled from 'styled-components';

const Game = ({ game }) => {
  const history = useHistory();
  const handleClickTeam = () => history.push('/play-screen');
  // 클릭하면 GET /games/{gameId} 요청 보내서
  // 입장 가능한 게임인지 데이터를 받아오고, 상태를 set한다.

  return (
    <GameLi>
      <Wrapper>
        <MatchNumber>GAME {game.id}</MatchNumber>
      </Wrapper>
      <Wrapper>
        <Team type='home' onClick={handleClickTeam}>
          {game.home_team.name}
        </Team>
        <Versus>vs</Versus>
        <Team type='away' onClick={handleClickTeam}>
          {game.away_team.name}
        </Team>
      </Wrapper>
    </GameLi>
  );
};

const GameLi = styled.li`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  background-color: ${({ theme }) => theme.colors.lightGray};
  width: 100%;
  height: 100px;
  border-radius: 14px;
  margin-bottom: 10px;
`;

const Wrapper = styled.div`
  display: flex;
`;

const MatchNumber = styled.span`
  color: red;
  margin-bottom: 6px;
`;

const Team = styled.div`
  /* font-size: ${({ theme }) => theme.fontSizes.XL}; */
  font-size: 32px;
  font-weight: bold;
  color: ${({ theme }) => theme.colors.darkGray};
  width: 180px;
  text-align: ${({ type }) => (type === 'home' ? 'right' : 'left')};

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
