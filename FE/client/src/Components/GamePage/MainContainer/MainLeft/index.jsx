import React from "react";
import styled from "styled-components";
import SBOStatus from "Components/GamePage/MainContainer/MainLeft/SBOStatus.jsx";
import BaseballField from "Components/GamePage/MainContainer/MainLeft/BaseballField";
import AttackDefendStatus from "Components/GamePage/MainContainer/MainLeft/AttackDefendStatus";

const MainLeft = () => {
  return (
    <MainLeftDiv>
      <SBOStatus />
      <BaseballField />
      <AttackDefendStatus />
    </MainLeftDiv>
  );
};

const MainLeftDiv = styled.div`
  display: flex;
  color: white;
`;

export default MainLeft;
