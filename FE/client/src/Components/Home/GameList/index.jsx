import React from "react";
import styled from "styled-components";
import Game from "./Game";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";

const GameList = () => {
  const [gameState] = useAsync(API.get.games);
  const { data, loading, error } = gameState;

  return (
    <GameBoxList>
      {loading && <>loading...</>}

      {data && Object.entries(data).map(([_, gameData], idx) => {
        return <Game key={`Game-${idx}`} {...{ gameData }} />
      })}

      {error && <>error...</>}
    </GameBoxList>
  );
};

const GameBoxList = styled.ul`
  display: flex;
  flex-direction: column;
  place-items: center;
  margin: 2rem auto;
  max-height: 18rem;
  gap: 1rem;
  width: 33rem;
  overflow-y: overlay;
  ::-webkit-scrollbar {
    width: 10px;
    display: none;
  }
  &:hover {
    -ms-overflow-style: none;
    ::-webkit-scrollbar {
      width: 10px;
      display: block;
    }
    ::-webkit-scrollbar-thumb {
      background-color: #2f3542;
      border-radius: 10px;
    }
    ::-webkit-scrollbar-track {
      background-color: grey;
      border-radius: 10px;
      box-shadow: inset 0px 0px 5px white;
    }
  }
`;

export default GameList;
