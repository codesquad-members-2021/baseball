import React, { createContext, useEffect, useState } from "react";
import GamePageHeader from "./GamePageHeader";
import MainContainer from "./MainContainer";
import Popup from "./Popup";
import styled from "styled-components";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";
import { GAME1 } from "utils/mockDatas";
import { randomPitch } from "utils/randomPitch";

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
  const [thisData, fetchThisData] = useAsync(API.get.inGameDatas, [], true);
  const { data: thisis } = thisData;
  const [attackState, setAttackState] = useState("away"); //attack하는 애가 awayteam인지 homeTeam인지
  const [sequenceCount, setSequenceCount] = useState(0); //몇번째 선수가 뛰고있는지
  const [roundCount, setRoundCount] = useState(1); //몇회인지 카운트
  const [currentBaseData, setCurrentBaseData] = useState([]); //Base에 누구누구 있는지
  const [currentSBData, setCurrentSBData] = useState({ strike: 0, ball: 0 });

  const onPitch = () => {
    const pitchResult = randomPitch();
    switch (pitchResult) {
      case "hit":
        setCurrentBaseData([
          ...currentBaseData,
          {
            name: inGameData[attackState][sequenceCount].name,
            id: inGameData[attackState][sequenceCount].id,
          },
        ]);
        break;
      case "ball":
        setCurrentSBData({
          strike: currentSBData.strike,
          ball: currentSBData.ball + 1,
        });
        break;
      case "strike":
        setCurrentSBData({
          strike: currentSBData.strike + 1,
          ball: currentSBData.ball,
        });
        break;
      default:
        return;
    }
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
    fetchThisData(gameId);
  }, [userState]);

  console.log("이것이다~!", thisis);

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
      value={{
        teamState,
        inGameData,
        attackState,
        sequenceCount,
        roundCount,
        onPitch,
        currentPlayData,
      }}
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
