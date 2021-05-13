import React, { createContext, useContext, useEffect, useState } from "react";
import GamePageHeader from "./GamePageHeader";
import MainContainer from "./MainContainer";
import Popup from "./Popup";
import styled from "styled-components";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";
import { GAME1 } from "utils/mockDatas";
import { randomPitch } from "utils/randomPitch";
import { PageContext } from "Components/Page";

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

  // const [inGameData, setInGameData] = useState(GAME1);
  const [inGameState, fetchInGameData] = useAsync(
    API.get.inGameDatas,
    [],
    true
  );
  const { data: inGameData } = inGameState;
  const [attackState, setAttackState] = useState("away"); //attack하는 애가 awayteam인지 homeTeam인지
  const [sequenceCount, setSequenceCount] = useState(0); //몇번째 선수가 뛰고있는지
  const [roundCount, setRoundCount] = useState(1); //몇회인지 카운트
  const [currentBaseData, setCurrentBaseData] = useState([]); //Base에 누구누구 있는지
  const [currentSBData, setCurrentSBData] = useState({ strike: 0, ball: 0 });

  const { socket } = useContext(PageContext);

  const onPitch = () => {
    socket.emit("pitchClicked", "퓟취");
  };

  useEffect(() => {
    if (!userState) return;
    const { gameId, teamKind } = userState;
    setTeamState({
      ...teamState,
      gameId,
      [teamKind]: { ...teamState[teamKind], isMyTeam: true },
    });
    fetchTeamInfoState(gameId);
    fetchInGameData(gameId);
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

  useEffect(() => {
    socket.on("pitchResult", (pitchResult) => {
      setCurrentSBData(pitchResult);
    });
  }, []);

  return (
    <GamePageContext.Provider
      value={{
        teamState,
        inGameData,
        attackState,
        sequenceCount,
        roundCount,
        currentSBData,
        onPitch,
      }}
    >
      <GamePageBackground>
        {loading && <>loading ...</>}

        {inGameData && data && (
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
