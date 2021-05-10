import React from "react";
import StatusBoardList from "./StatusBoardList";
import styled from "styled-components";
const MainRight = () => {
  return (
    <MainRightDiv>
      <StatusBoardList />
    </MainRightDiv>
  );
};

const MainRightDiv = styled.div`
  height: 100%;
  border-left: 1px solid #e2e2e2;
  padding: 0.5rem 1rem;

  color: white;
  width: 20%;
`;

export default MainRight;
