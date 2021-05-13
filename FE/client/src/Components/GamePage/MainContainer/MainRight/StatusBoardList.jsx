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
        name={`${inGameData[attackState][sequenceCount].name}`}
        id={`${inGameData[attackState][sequenceCount].id}`}
      />
    </div>
  );
};

export default StatusBoardList;
