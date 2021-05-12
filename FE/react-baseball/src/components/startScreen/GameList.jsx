import axios from 'axios';
import { useEffect, useState } from 'react';
import styled from 'styled-components';
import Game from './Game';

const GameList = (props) => {
  const [games, setGames] = useState([]);
  const fetchData = async () => {
    const {
      data: { games },
    } = await axios.get('http://localhost:3000/games-modi.json');
    setGames(games);
  };

  useEffect(fetchData, []);

  return (
    <GameUl>
      <GamesWrapper>
        {games.map((game) => (
          <Game key={game.gameId} game={game} />
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
