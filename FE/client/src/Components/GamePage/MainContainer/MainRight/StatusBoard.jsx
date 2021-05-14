import React from "react";
import StatusBoardItems from "./StatusBoardItems";
import styled from "styled-components";

const StatusBoard = ({ name, currentPlayer, id, records, out, fourBall }) => {
  return (
    <StatusBoardDiv>
      <StatusTitle currentPlayer={currentPlayer}>
        {id}번 타자 {name}
      </StatusTitle>
      {out && <FinishItem>아웃</FinishItem>}
      {fourBall && <FinishItem>볼넷 진루~!</FinishItem>}
      {records.map((record, index) => {
        return (<StatusBoardItems key={`statusItems-${index}`} {...{ record, index, recordLength: records.length }} />)
      })}
    </StatusBoardDiv>
  );
};

const FinishItem = styled.div`
  margin:auto;
  color: #47abc4;
  font-weight:700;
`;

const StatusBoardDiv = styled.div`
  display: flex;
  flex-direction: column;
  margin-bottom: 2.5rem;
`;

const StatusTitle = styled.div`
  font-weight: bold;
  margin-bottom: 0.3rem;
  color: ${(props) => (props.currentPlayer ? "orange" : " #9ee6e6")};
`;

export default StatusBoard;
