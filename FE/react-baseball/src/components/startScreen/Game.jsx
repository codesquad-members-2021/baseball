import styled from 'styled-components';
import Team from './Team';

const Game = ({ game }) => {
  return (
    <GameLi>
      <Wrapper>
        <MatchNumber>GAME {game.gameId}</MatchNumber>
      </Wrapper>
      <Wrapper>
        <Team type='away' game={game} />
        <Versus>vs</Versus>
        <Team type='home' game={game} />
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

const Versus = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XL};
  margin: 0 40px;
  display: flex;
  align-items: center;
  font-weight: bolder;
  color: ${({ theme }) => theme.colors.gray};
`;
export default Game;
