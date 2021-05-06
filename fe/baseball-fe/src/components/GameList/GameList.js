import { useState, useEffect } from "react";
import styled from "styled-components";
import GameListItem from "./GameListItem";

function GameList() {
  const [gameList, setGameList] = useState();

  useEffect(() => {
    // TODO: fetch data
    setGameList([
      {
        id: 1,
        home: {
          name: "hanwha",
        },
        away: {
          name: "kium",
        },
      },
      {
        id: 1,
        home: {
          name: "Twins",
        },
        away: {
          name: "Doosan",
        },
      },
      {
        id: 1,
        home: {
          name: "Twins",
        },
        away: {
          name: "Doosan",
        },
      },
      {
        id: 1,
        home: {
          name: "Twins",
        },
        away: {
          name: "Doosan",
        },
      },
    ]);
  }, []);

  return (
    <StyledGameList>
      {gameList &&
        gameList.map((match, idx) => (
          <GameListItem key={idx} match={match} idx={idx} />
        ))}
    </StyledGameList>
  );
}

export default GameList;

const StyledGameList = styled.ul`
  width: 30rem;
  height: 20rem;
  border: 1px solid red;
  padding: 0;
  overflow-y: scroll;
`;
