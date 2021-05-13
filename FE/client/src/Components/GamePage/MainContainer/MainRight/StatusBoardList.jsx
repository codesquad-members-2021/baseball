import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import StatusBoard from "./StatusBoard";

const StatusBoardList = () => {
  const { inGameData, sequenceCount, attackState } =
    useContext(GamePageContext);

  return (
    <div>
      <StatusBoard
        currentPlayer
        name={`${inGameData && inGameData[attackState][sequenceCount].name}`}
        id={`${sequenceCount + 1}`}
      />
    </div>
  );
};

export default StatusBoardList;
