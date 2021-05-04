import React from "react";
import styled from "styled-components";

const StatusBoardItems = (props) => {
  return (
    <>
      <StatusBoardItem>
        <NumberCircle>1</NumberCircle>스트라이크
        <StrikeBallStatus>S2 B2</StrikeBallStatus>
      </StatusBoardItem>
      <StatusBoardItem>
        <NumberCircle>1</NumberCircle>볼
        <StrikeBallStatus>S2 B2</StrikeBallStatus>
      </StatusBoardItem>
      <StatusBoardItem>
        <NumberCircle>1</NumberCircle>스트라이크
        <StrikeBallStatus>S2 B2</StrikeBallStatus>
      </StatusBoardItem>
      <StatusBoardItem>
        <NumberCircle>1</NumberCircle>스트라이크
        <StrikeBallStatus>S2 B2</StrikeBallStatus>
      </StatusBoardItem>
    </>
  );
};

const StatusBoardItem = styled.div`
  display: flex;
  margin: 0.3rem 0.2rem;
  justify-content: space-between;
`;
const NumberCircle = styled.div`
  width: 1.5rem;
  height: 1.5rem;
  color: black;
  text-align: Center;
  border-radius: 70%;
  font-weight: bold;
  background: white;
  margin-right: 0.3rem;
`;

const StrikeBallStatus = styled.div`
  color: #e2e2e2;
`;

export default StatusBoardItems;
