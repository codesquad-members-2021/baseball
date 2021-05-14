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


  const [inGameState, fetchInGameData] = useAsync(
    API.get.inGameDatas,
    [],
    true
  );
  const { data: inGameData } = inGameState;
  const [memberFirstRecords, fetchMemberRecords] = useAsync(API.get.inGameDatas);
  const [memberRecords, setMemberRecords] = useState();

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
  const [teamScore, setTeamScore] = useState({ home: 0, away: 0 });


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
    fetchMemberRecords(data.gameId);
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
    const teamId = attackState === 'away' ? data.teamScores[1].teamId : data.teamScores[0].teamId;
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
        attackState === 'away'
          ? setTeamScore((teamScore) => ({ ...teamScore, away: teamScore.away + 1 }))
          : setTeamScore((teamScore) => ({ ...teamScore, home: teamScore.home + 1 }))
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
        setCurrentScore((currentScore) => currentScore + 1); //점수 업데이트
        attackState === 'away'
          ? setTeamScore((teamScore) => ({ ...teamScore, away: teamScore.away + 1 }))
          : setTeamScore((teamScore) => ({ ...teamScore, home: teamScore.home + 1 }))
      }
    }
    if (outState === 2 && strike === 3 && action === "strike") {
      // 팀 체인지
      socket.emit('plusScore', ({ teamId: teamId, postData: { "inningNumber": roundCount, "score": currentScore } }));
      if (attackState === 'home') setRoundCount((round) => round + 1);
      setCurrentSBData({ strike: 0, ball: 0, action: "" });
      setPlayRecordsState((records) => {
        const [firstRecord, ...remainRecords] = records;
        return [{ ...firstRecord, out: true }, ...remainRecords];
      });
      setAttackState((attackState) =>
        attackState === "away" ? "home" : "away"
      );
      setCurrentScore(0);
      setSequenceCount(0);
      setOutState(0);
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
    const isAway = attackState === 'away';
    const teamId = isAway ? data.teamScores[1].teamId : data.teamScores[0].teamId;
    const teamKind = isAway ? 'away' : 'home';

    const isOut = playRecordsState[0].records[0].strike === 3; //아웃되었을때
    const isHit = playRecordsState[0].records[0].action === 'hit'; //히트일때

    const currentMember = memberRecords[teamKind].find(({ id }) => {
      return id === playRecordsState[0].id;
    });

    if (!currentMember) return;
    currentMember.out = isOut ? currentMember.out + 1 : currentMember.out;
    currentMember.hit = isHit ? currentMember.hit + 1 : currentMember.hit;

    setMemberRecords((memberRecords) => {
      const changeMemberIndex = memberRecords[teamKind].find(({ id }) => {
        return id === playRecordsState[0].id;
      });
      memberRecords[teamKind].splice(changeMemberIndex, 1);
      return { ...memberRecords, [teamKind]: [...memberRecords[teamKind], currentMember] }
    })

    const postData = {
      "hit": currentMember.hit,
      "out": currentMember.out
    }

    socket.emit('plusMemberScore', { teamId, memberId: playRecordsState[0].id, postData });

    if (!sequenceCount) return;
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

  useEffect(() => {
    if (!memberFirstRecords.data) return;
    setMemberRecords(memberFirstRecords.data);
  }, [memberFirstRecords])

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
        teamScore,
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