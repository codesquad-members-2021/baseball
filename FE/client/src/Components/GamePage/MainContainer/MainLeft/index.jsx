import React from "react";
import styled from "styled-components";
import SBOStatus from "./SBOStatus.jsx";
import BaseballField from "./BaseballField";
import AttackDefendStatus from "./AttackDefendStatus";
import BackgroundImage from "Images/Background.jpg";

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
  justify-content: space-between;
  width: 80%;
  background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
    url(${BackgroundImage});
  background-repeat: no-repeat;
  background-size: 100% 100%;
  height: 100%;
`;

export default MainLeft;
