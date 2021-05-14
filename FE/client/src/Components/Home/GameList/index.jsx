import React, { useContext, useEffect, useState } from "react";
import styled from "styled-components";
import Game from "./Game";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";
import { PageContext } from "Components/Page";

const GameList = () => {
  const { socket } = useContext(PageContext);
  const [selectedTeamState, setSelectTeamState] = useState([]);
  const [allTeamState, setAllTeamState] = useState([]);
  const [gameState] = useAsync(API.get.games);
  const { data, loading, error } = gameState;

  useEffect(() => {
    socket.on("selectedTeam", (baseballGames) => {
      setSelectTeamState(baseballGames);
    });
  }, []);

  useEffect(() => {
    if (!data) return;
    const dataArray = Array.from(Object.entries(data), ([_, v]) => ({
      ...v,
      home: null,
      away: null,
    }));
    const allTeam = dataArray.map((allGame) => {
      const selectedTeam = selectedTeamState.filter((selected) => {
        return allGame.id === selected.gameId;
      });
      return selectedTeam.reduce((acc, cur) => {
        acc[cur.teamKind] = cur.playerId;
        return acc;
      }, allGame);
    });
    setAllTeamState(allTeam);
  }, [data, selectedTeamState]);

  return (
    <GameBoxList>
      {loading && <>loading...</>}

      {allTeamState.length &&
        allTeamState.map((gameData, idx) => {
          return <Game key={`Game-${idx}`} {...{ gameData }} />;
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