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
  const [currentSBData, setCurrentSBData] = useState({ strike: 0, ball: 0, out: 0, action: '' });
  const [currentPlayAction, setCurrentPlayAction] = useState(''); ////strike, ball, hit;
  const [playRecordsState, setPlayRecordsState] = useState([]); ////[{id:1,name:홍길동,records:[{strike:0, ball:1}]}]

  const onPitch = () => {
    socket.emit('pitch', { gameId: userState.gameId });
  };

  const updateSequenceCount = () => {
    return setSequenceCount((sequenceCount) => {
      if (sequenceCount === 8) return 0;
      return sequenceCount + 1;
    });
  }

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
        'strike': (currentData) => ({ ...currentData, strike: currentData.strike + 1, action: playAction }),
        'ball': (currentData) => ({ ...currentData, ball: currentData.ball + 1, action: playAction }),
        'hit': (currentData) => ({ ...currentData, strike: 0, ball: 0, action: playAction })
      }
      setCurrentPlayAction(playAction);
      setCurrentSBData((currentData) => playActionObject[playAction](currentData));
    });
  }, []);

  useEffect(() => { //
    if (!playRecordsState.length) return;
    const { strike, ball, out, action } = currentSBData;
    console.log(12315135, strike)
    if (strike === 3) {
      updateSequenceCount();
    } else if (ball === 4) {
      //안타 처리
    } else if (out === 3) {
      //팀 체인지 
    } else if (action === 'hit') {
      updateSequenceCount();
    }


    setPlayRecordsState((records) => {
      const [firstRecord, ...remainRecords] = records;
      return [{ ...firstRecord, records: [currentSBData, ...firstRecord.records] }, ...remainRecords];
    });
  }, [currentSBData]);

  useEffect(() => { //초기세팅 record 세팅 (mainRight)
    if (!inGameData) return;
    const { away } = inGameData;
    setPlayRecordsState([{ id: away[0].id, name: away[0].name, records: [] }])
  }, [inGameData]);

  useEffect(() => {//선수교체 record 세팅(mainRight)
    if (!inGameData) return;
    const { away } = inGameData;
    setPlayRecordsState((records) => {
      return [{ id: away[sequenceCount].id, name: away[sequenceCount].name, records: [] }, ...records];
    });
  }, [sequenceCount])


  useEffect(() => {
    console.log(123545, playRecordsState)
  }, [playRecordsState])
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
