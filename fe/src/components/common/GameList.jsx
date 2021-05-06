import GameCard from "./GameCard";
import { useState, useEffect } from "react";
import styled from "styled-components";

const GameList = () => {
  const [games, setGames] = useState([]);
  useEffect(() => {
    // API로 불러옴
    const planningDocumentGames = [
      ["captain", "marvel"],
      ["twins", "tigers"],
      ["rockets", "dodgers"],
      ["captain", "marvel"],
      ["twins", "tigers"],
      ["rockets", "dodgers"],
      ["captain", "marvel"],
      ["twins", "tigers"],
      ["rockets", "dodgers"],
      ["captain", "marvel"],
      ["twins", "tigers"],
      ["rockets", "dodgers"],
    ];
    setGames(planningDocumentGames);
  }, []);

  return (
    <GameListLayout>
      {games.map((game, idx) => (
        <GameCard key={`gameCard-${idx}`} game={game} idx={idx + 1} />
      ))}
    </GameListLayout>
  );
};

const GameListLayout = styled.div`
  width: 100%;
  height: 33vh;
  display: flex;
  flex-direction: column;
  /* outline: blue solid; */
  overflow: scroll;
  margin-top: 20%;
`;
export default GameList;
