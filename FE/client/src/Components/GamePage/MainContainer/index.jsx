import React from "react";
import MainLeft from "./MainLeft";
import MainRight from "./MainRight";
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
  height: 78%;
  justify-content: space-between;
`;

export default MainContainer;
