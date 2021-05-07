const Game = ({ game }) => {
  return (
    <li>
      <div>{game.home_team.name}</div>
      <div>{game.away_team.name}</div>
    </li>
  );
};

export default Game;
