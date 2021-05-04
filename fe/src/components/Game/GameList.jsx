import { useState, useEffect } from "react";
import GameListItem from "./GameListItem.jsx";

const GameList = () => {
  const [games, setGames] = useState([]);

  useEffect(() => {
    // API로 불러옴
    const planningDocumentGames = [
      ["captain", "marvel"],
      ["twins", "tigers"],
      ["rockets", "dodgers"],
    ];
    setGames(planningDocumentGames);
  }, []);

  return (
    <GameListLayout>
      {games.map((game, idx) => (
        <GameListItem key={idx} game={game} idx={idx + 1}></GameListItem>
      ))}

      {/* <div className={"game-list-item"}></div>
      <div className={"game-list-item"}></div>
      <div className={"game-list-item"}></div>
      <div className={"game-list-item"}></div> */}
    </GameListLayout>
  );
};

const GameListLayout = styled.section`
  width: 100%;
  height: 600px;

  overflow: scroll;

  display: flex;
  flex-direction: column;
  align-items: center;

  /* .game-list-item + .game-list-item {
    margin-top: 10px;
  } */
`;

export default GameList;
