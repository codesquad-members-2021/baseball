import { useState, useEffect } from "react";
import styled from "styled-components";
import GameListItem from "./GameListItem";
import useFetch from 'util/hook/useFetch';
import API from 'util/API';

function GameList() {
  const [gameList, setGameList] = useState();
  const { response , error, isLoading } = useFetch(API.matches);

  useEffect(() => {
    if (!response) return;
    setGameList(response.matches);
  }, [response]);

  useEffect(() => {
    console.error(error);
  }, [error]);

  return (
    <StyledGameList>
      {gameList &&
        gameList.map((match, idx) => (
          <GameListItem key={idx} match={match} idx={idx} isLoading={isLoading}/>
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

