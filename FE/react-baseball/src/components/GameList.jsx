import styled from 'styled-components';
import games from '../mockData';
import Game from './Game';

const GameList = (props) => {
  return (
    <GameUl>
      {games.map((game) => (
        <Game key={game.id} game={game} />
      ))}
    </GameUl>
  );
};

const GameUl = styled.ul`
  display: flex;
  flex-direction: column;
  /* gap: 14px 0; */
  width: 500px;
  height: 300px;
  overflow-y: scroll;
`;

export default GameList;
