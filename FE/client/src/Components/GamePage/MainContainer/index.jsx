import React from "react";
import MainLeft from "Components/GamePage/MainContainer/MainLeft";
import MainRight from "Components/GamePage/MainContainer/MainRight";
import styled from "styled-components";

const MainContainer = () => {
  return (
    <MainContainerDiv>
      <MainLeft />
      <MainRight />
    </MainContainerDiv>
  );
};

const MainContainerDiv = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: space-between;
`;

export default MainContainer;
