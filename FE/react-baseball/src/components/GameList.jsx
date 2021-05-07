import styled from 'styled-components';
import games from '../mockData';
import Game from './Game';

const GameList = (props) => {
  return (
    <GameUl>
      <GamesWrapper>
        {games.map((game) => (
          <Game key={game.id} game={game} />
        ))}
      </GamesWrapper>
    </GameUl>
  );
};

const GameUl = styled.ul`
  display: flex;
  flex-direction: column;
`;

const GamesWrapper = styled.div`
  width: 540px;
  height: 320px;
  overflow-y: scroll;
`;

export default GameList;
