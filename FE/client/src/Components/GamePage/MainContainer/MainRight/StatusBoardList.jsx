import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import StatusBoard from "./StatusBoard";

const StatusBoardList = ({ index }) => {
  const { inGameData, sequenceCount, attackState, playRecordsState } =
    useContext(GamePageContext);
  {/* playRecordsState[0].records.ball &&
        playRecordsState[0].records.strike && */}
  return (
    <div>
      {playRecordsState.length &&

        playRecordsState.map(({ name, records }, index) => {
          console.log(records)
          return (<StatusBoard
            currentPlayer={index === 0}
            id={`${sequenceCount + 1}`}
            {...{ name, records }}
          />)
        })}
    </div>
  );
};

export default StatusBoardList;
