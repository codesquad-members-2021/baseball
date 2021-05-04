import React from "react";
import StatusBoardList from "Components/GamePage/MainContainer/MainRight/StatusBoardList";
import styled from "styled-components";
const MainRight = () => {
  return (
    <MainRightDiv>
      <StatusBoardList />
      hello
    </MainRightDiv>
  );
};

const MainRightDiv = styled.div`
  width: 20rem;
  height: 100%;
  border-left: 1px solid #e2e2e2;
  padding: 0.5rem 1rem;
  color: white;
`;

export default MainRight;
