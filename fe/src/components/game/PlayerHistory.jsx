import React, { useContext } from "react";
import styled from "styled-components";
import { GlobalContext } from "../../App";

const PlayerHistory = ({ history }) => {
  const { currPlayer } = useContext(GlobalContext);
  const actionName = {
    S: "스트라이크",
    B: "볼",
    H: "안타",
  };
  const lastHistory = history.historyList[history.historyList.length - 1];
  let lastAction = null;
  if (lastHistory.out === 1) lastAction = "아웃!";
  else if (lastHistory.ball === 4) lastAction = "볼넷!";
  else lastAction = "안타!";
  return (
    <PlayerHistoryContainer>
      {/*styled-component*/}
      <CurrPlayer>
        <div>
          {currPlayer.playerBattingOrder}번 타자 {currPlayer.playerName}
        </div>
        <PlayerLog>
          {currPlayer.historyList.length &&
            [...currPlayer.historyList].map((historyLog, i) => {
              return (
                <li>
                  <span>{i + 1}</span>
                  <span>{actionName[historyLog.actionName]}</span>
                  <span>
                    S{historyLog.strike} B{historyLog.ball}
                  </span>
                </li>
              );
            })}
        </PlayerLog>
      </CurrPlayer>
      <PastPlayers>
        <div>
          {history.playerBattingOrder}번 타자 {history.playerName}
        </div>
        <div>{history.historyList.length && lastAction}</div>
        <PlayerLog>
          {history.historyList.length &&
            [...history.historyList].map((historyLog, i) => {
              return (
                <li>
                  <span>{i + 1}</span>
                  <span>{actionName[historyLog.actionName]}</span>
                  <span>
                    S{historyLog.strike} B{historyLog.ball}
                  </span>
                </li>
              );
            })}
        </PlayerLog>
      </PastPlayers>
    </PlayerHistoryContainer>
  );
};

export default PlayerHistory;

const PlayerHistoryContainer = styled.div``;

const PlayerLog = styled.ul`
  display: flex;
  flex-direction: column-reverse;
`;

const CurrPlayer = styled.div``;
const PastPlayers = styled.div``;
