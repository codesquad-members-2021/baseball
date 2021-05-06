import games from '../mockData';
import Game from './Game';

const GameList = props => {
  return (
    <ul>
      {games.map(game => (
        <Game key={game.id} game={game} />
      ))}
    </ul>
  );
};

export default GameList;
