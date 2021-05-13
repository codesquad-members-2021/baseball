import React, { createContext, useEffect, useState } from "react";
import GamePageHeader from "./GamePageHeader";
import MainContainer from "./MainContainer";
import Popup from "./Popup";
import styled from "styled-components";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";
import { GAME1 } from "utils/mockDatas";

export const GamePageContext = createContext();

const GamePage = ({ userState }) => {
  const [teamInfoState, fetchTeamInfoState] = useAsync(
    API.get.scores,
    [],
    true
  ); //팀 정보를 알아내기 위한 요청
  const { data, loading, error } = teamInfoState;
  const [teamState, setTeamState] = useState({
    gameId: 0,
    home: { isMyTeam: false, teamId: 0, teamName: "" },
    away: { isMyTeam: false, teamId: 0, teamName: "" },
  });
  const [inGameData, setInGameData] = useState(GAME1);
  const [attackState, setAttackState] = useState("away");
  const [sequenceCount, setSequenceCount] = useState(0);

  useEffect(() => {
    if (!userState) return;
    const { gameId, teamKind } = userState;
    setTeamState({
      ...teamState,
      gameId,
      [teamKind]: { ...teamState[teamKind], isMyTeam: true },
    });
    fetchTeamInfoState(gameId);
  }, [userState]);

  useEffect(() => {
    if (!data) return;
    const { teamScores } = data;
    setTeamState({
      ...teamState,
      home: {
        ...teamState.home,
        teamId: teamScores[0].teamId,
        teamName: teamScores[0].teamName,
        isAttack: false,
      },
      away: {
        ...teamState.away,
        teamId: teamScores[1].teamId,
        teamName: teamScores[1].teamName,
        isAttack: true,
      },
    });
  }, [data]);
  console.log(teamState);
  console.log("인게임", inGameData);

  return (
    <GamePageContext.Provider
      value={{ teamState, inGameData, attackState, sequenceCount }}
    >
      <GamePageBackground>
        {loading && <>loading ...</>}

        {data && (
          <>
            <Popup />
            <GamePageHeader {...{ data }} />
            <MainContainer />
          </>
        )}

        {error && <>error ...</>}
      </GamePageBackground>
    </GamePageContext.Provider>
  );
};

const GamePageBackground = styled.div`
  height: 100vh;
  background: black;
  opacity: 0.9;
`;

export default GamePage;
