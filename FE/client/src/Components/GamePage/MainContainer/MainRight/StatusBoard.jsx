import React from "react";
import StatusBoardItems from "Components/GamePage/MainContainer/MainRight/StatusBoardItems";
import styled from "styled-components";

const StatusBoard = (props) => {
  return (
    <StatusBoardDiv>
      <StatusTitle currentPlayer={props.currentPlayer}>
        7번 타자 {props.name}
      </StatusTitle>
      <StatusBoardItems />
    </StatusBoardDiv>
  );
};

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
