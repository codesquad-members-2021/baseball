import React, { useContext, useEffect } from "react";
import styled from "styled-components";
import { GlobalContext } from "../../../App";
import PitchButton from "./PitchButton";

const Diamond = (props) => {
  const { currInning, setHomeTeam, setExpeditionTeam, currHitter, setCurrHitter, currS, setCurrS, currH, setCurrH, currB, setCurrB, currO, setCurrO } = useContext(GlobalContext);

  const resetSB = () => {
    setCurrS(0);
    setCurrB(0);
  };

  const nowPitchingTeam = currInning.cycle === "초" ? "homeTeam" : "expeditionTeam";

  useEffect(() => {
    const actionBoard = { currHitter, S: currS, B: currB, O: currO, H: currH };
    localStorage.setItem("currHitter", JSON.stringify(actionBoard));
  }, [currS, currB, currH, currO]);

  const throwBaseball = () => {
    const actions = ["S", "B", "H"];
    const selectedIndex = parseInt(Math.random() * actions.length);
    alert(`결과: ${actions[selectedIndex]}`); // 일단!!!

    if (actions[selectedIndex] === "S") {
      if (currS < 2) {
        setCurrS((currS) => currS + 1);
        setCurrHitter((hitter) => {
          const newHitter = JSON.parse(JSON.stringify(hitter));
          newHitter.historyList.push({
            id: newHitter.historyList.length + 1,
            actionName: actions[selectedIndex],
            strike: currS + 1,
            ball: currB,
            out: currO,
          });
          return newHitter;
        });
      } else {
        setCurrHitter((hitter) => {
          const newHitter = JSON.parse(JSON.stringify(hitter));
          newHitter.plateAppearances++;
          newHitter.historyList.push({
            id: newHitter.historyList.length + 1,
            actionName: actions[selectedIndex],
            strike: currS + 1,
            ball: currB,
            out: currO + 1, // db에 보내기 위한 용도로만 해줄 거니까 굳이 상태를 갱신해서 리렌더할 필요가 없음
          });
          return newHitter;
        });
        resetSB();

        if (currO < 2) {
          // 선수 교체
          alert("선수 교체함다~");
          setCurrO((currO) => currO + 1); // 빨간공 하나 적재 됨
          // 데이터베이스에 다음 선수 정보 요청, 응답 받음
          // 응답 받으면 여기서 또 Teams에서 셋팅해준 로직과 같은 것을 수행해야 함
        } else {
          // 팀 교체
          alert("팀 교체함다~");
          // 데이터베이스에 로컬스토리지의 정보를 저장, 이때는 SBOH 모두 리셋
          // 다음 공격팀, 투수, 타자 등의 전체 정보를 응답 받음, 여기서 또 Teams에서 셋팅해준 로직과 같은 것을 수행해야 함
        }
      }
    } else if (actions[selectedIndex] === "B") {
      if (currB < 3) {
        setCurrB((currB) => currB + 1);
        setCurrHitter((hitter) => {
          const newHitter = JSON.parse(JSON.stringify(hitter));
          newHitter.historyList.push({
            id: newHitter.historyList.length + 1,
            actionName: actions[selectedIndex],
            strike: currS,
            ball: currB + 1,
            out: currO,
          });
          return newHitter;
        });
      } else {
        alert("볼넷임다~");
        // 지금 타자 진루, 현재 나가있는 선수들도 모두 한칸씩 진루시킴
        // 만약에 홈으로 들어오는 선수가 있으면 현재 팀의 totalScore+1 해줘야 함
        setCurrHitter((hitter) => {
          const newHitter = JSON.parse(JSON.stringify(hitter));
          newHitter.plateAppearances++;
          newHitter.historyList.push({
            id: newHitter.historyList.length + 1,
            actionName: actions[selectedIndex],
            strike: currS,
            ball: currB + 1,
            out: currO,
          });
          return newHitter;
        });
        if (nowPitchingTeam === "homeTeam") {
          setExpeditionTeam((expedition) => {
            const newExpedition = { ...expedition };
            newExpedition.totalScore++;
            return newExpedition;
          });
        } else {
          setHomeTeam((home) => {
            const newHome = { ...home };
            newHome.totalScore++;
            return newHome;
          });
        }
        // 데이터베이스에 다음 선수 정보 요청, 응답 받음 <- 이때 팀들의 totalScore도 데이터베이스에 저장함
        resetSB();
        // Teams 로직 또 수행 (아마도 필요한 부분만 수행하겟지...?)
      }
    } else if (actions[selectedIndex] === "H") {
      alert("선수 교체함다~");
      setCurrH((currH) => currH + 1);
      setCurrHitter((hitter) => {
        const newHitter = JSON.parse(JSON.stringify(hitter));
        newHitter.plateAppearances++;
        newHitter.hits++;
        newHitter.historyList.push({
          id: newHitter.historyList.length + 1,
          actionName: actions[selectedIndex],
          strike: currS,
          ball: currB,
          out: currO,
        });
        return newHitter;
      });
      resetSB();
    }
  };

  return (
    <DiamondField>
      <div>다이아몬드 경기장을 넣을 거임</div>
      {/* <PitchButton /> */}
      <button onClick={throwBaseball}>pitch</button>
    </DiamondField>
  );
};

export default Diamond;

const DiamondField = styled.div`
  width: 100%;
`;
