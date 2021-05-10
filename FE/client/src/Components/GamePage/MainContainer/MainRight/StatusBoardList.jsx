import React from "react";
import StatusBoard from "./StatusBoard";

const StatusBoardList = () => {
  return (
    <div>
      <StatusBoard currentPlayer name="류현진" />
      <StatusBoard name="김제니" />
      <StatusBoard name="김비모" />
    </div>
  );
};

export default StatusBoardList;
