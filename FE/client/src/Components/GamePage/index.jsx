import React, { createContext, useContext, useEffect, useState } from "react";
import GamePageHeader from "./GamePageHeader";
import MainContainer from "./MainContainer";
import Popup from "./Popup";
import styled from "styled-components";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";
import { PageContext } from "Components/Page";

export const GamePageContext = createContext();

const GamePage = ({ userState }) => {
  const { socket } = useContext(PageContext);
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
  const [currentSBData, setCurrentSBData] = useState({
    strike: 0,
    ball: 0,
    action: "",
  });
  const [currentPlayAction, setCurrentPlayAction] = useState(""); ////strike, ball, hit;
  const [playRecordsState, setPlayRecordsState] = useState([]); ////[{id:1,name:홍길동,records:[{strike:0, ball:1}]}]
  const [currentScore, setCurrentScore] = useState(0); // 현재 게임의 스코어
  const [outState, setOutState] = useState(0);

  const onPitch = () => {
    socket.emit("pitch", { gameId: userState.gameId });
  };

  const updateSequenceCount = () => {
    return setSequenceCount((sequenceCount) => {
      if (sequenceCount === 8) return 0;
      return sequenceCount + 1;
    });
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
    socket.on("pitchResult", ({ playAction }) => {
      const playActionObject = {
        strike: (currentData) => ({
          ...currentData,
          strike: currentData.strike + 1,
          action: playAction,
        }),
        ball: (currentData) => ({
          ...currentData,
          ball: currentData.ball + 1,
          action: playAction,
        }),
        hit: (currentData) => ({
          ...currentData,
          strike: 0,
          ball: 0,
          action: playAction,
        }),
      };
      setCurrentPlayAction(playAction);
      setCurrentSBData((currentData) =>
        playActionObject[playAction](currentData)
      );
    });
  }, []);

  useEffect(() => {
    if (!playRecordsState.length) return;
    const { strike, ball, action } = currentSBData;
    if (strike === 3) {
      updateSequenceCount();
      setPlayRecordsState((records) => {
        const [firstRecord, ...remainRecords] = records;
        return [{ ...firstRecord, out: true }, ...remainRecords];
      });
      setCurrentSBData({ strike: 0, ball: 0, action: "" });
      setOutState((outState) => outState + 1);
    } else if (ball === 4) {
      updateSequenceCount();
      setPlayRecordsState((records) => {
        const [firstRecord, ...remainRecords] = records;
        return [{ ...firstRecord, fourBall: true }, ...remainRecords];
      });
      setCurrentSBData({ strike: 0, ball: 0, action: "" });
      setCurrentBaseData((base) => {
        // 볼넷이나 히트일때 base 업데이트
        const { name, id } = playRecordsState[0];
        if (base.length === 3) return [{ name, id }, ...base.slice(0, -1)];
        return [{ name, id }, ...base];
      });
      if (currentBaseData.length === 3) {
        setCurrentScore((currentScore) => currentScore + 1); //점수 업데이트
      }
    } else if (action === "hit") {
      updateSequenceCount();
      setCurrentBaseData((base) => {
        // 볼넷이나 히트일때 base 업데이트
        const { name, id } = playRecordsState[0];
        if (base.length === 3) return [{ name, id }, ...base.slice(0, -1)];
        return [{ name, id }, ...base];
      });
      if (currentBaseData.length === 3) {
        socket.emit('plusScore', ({ teamId: 1, postData: { "inningNumber": 1, "score": 3 } }));
        setCurrentScore((currentScore) => currentScore + 1); //점수 업데이트
      }
    } else if (outState === 2 && strike === 2 && action === "strike") {
      // 팀 체인지
      setCurrentSBData({ strike: 0, ball: 0, action: "" });
      setPlayRecordsState((records) => {
        const [firstRecord, ...remainRecords] = records;
        return [{ ...firstRecord, out: true }, ...remainRecords];
      });
      setAttackState((attackState) =>
        attackState === "away" ? "home" : "away"
      );
      setOutState(0);
      setSequenceCount(0);
      setCurrentBaseData([]);
    }

    if (!action) return;
    setPlayRecordsState((records) => {
      const [firstRecord, ...remainRecords] = records;
      return [
        { ...firstRecord, records: [currentSBData, ...firstRecord.records] },
        ...remainRecords,
      ];
    });
  }, [currentSBData]);

  useEffect(() => {
    //초기세팅 record 세팅 (mainRight)
    if (!inGameData) return;
    const { away } = inGameData;
    setPlayRecordsState([
      { id: away[0].id, name: away[0].name, out: false, records: [] },
    ]);
  }, [inGameData]);

  useEffect(() => {
    if (!inGameData) return;
    const { away, home } = inGameData;
    if (attackState === "away")
      setPlayRecordsState([
        {
          id: away[sequenceCount].id,
          name: away[sequenceCount].name,
          out: false,
          records: [],
        },
      ]);
    else
      setPlayRecordsState([
        {
          id: home[sequenceCount].id,
          name: home[sequenceCount].name,
          out: false,
          records: [],
        },
      ]);
  }, [attackState]);

  useEffect(() => {
    //선수교체 record 세팅(mainRight)
    if (!inGameData) return;
    const { away, home } = inGameData;
    if (attackState === "away")
      setPlayRecordsState((records) => {
        return [
          {
            id: away[sequenceCount].id,
            name: away[sequenceCount].name,
            out: false,
            records: [],
          },
          ...records,
        ];
      });
    else
      setPlayRecordsState((records) => {
        return [
          {
            id: home[sequenceCount].id,
            name: home[sequenceCount].name,
            out: false,
            records: [],
          },
          ...records,
        ];
      });
  }, [sequenceCount]);

  return (
    <GamePageContext.Provider
      value={{
        teamState,
        inGameData,
        attackState,
        sequenceCount,
        roundCount,
        currentSBData,
        currentPlayAction,
        playRecordsState,
        outState,
        currentBaseData,
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