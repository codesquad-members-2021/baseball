import React from "react";
import styled from "styled-components";
import SBOStatus from "Components/GamePage/MainContainer/MainLeft/SBOStatus.jsx";

const MainLeft = () => {
  return (
    <MainLeftDiv>
      <SBOStatus />
    </MainLeftDiv>
  );
};

const MainLeftDiv = styled.div`
  color: white;
  width: 50rem;
`;

export default MainLeft;
