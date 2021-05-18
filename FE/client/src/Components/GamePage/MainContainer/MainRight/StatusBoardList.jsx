import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import StatusBoard from "./StatusBoard";

const StatusBoardList = () => {
  const { playRecordsState } = useContext(GamePageContext);

  return (
    <div>
      {playRecordsState.length &&
        playRecordsState.map(({ id, name, records, out, fourBall }, index) => {
          return (<StatusBoard key={`statusBoard-${index}`}
            currentPlayer={index === 0}
            {...{ name, records, id, out, fourBall }}
          />)
        })}
    </div>
  );
};

export default StatusBoardList;