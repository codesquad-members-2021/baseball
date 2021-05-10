import React from "react";
import GamePageHeader from "./GamePageHeader";
import MainContainer from "./MainContainer";
import Popup from "./Popup";
import styled from "styled-components";

const GamePage = () => {
  return (
    <GamePageBackground>
      <Popup />
      {/*<TopPopup />*/}
      <GamePageHeader />
      <MainContainer />
    </GamePageBackground >
  );
};

const GamePageBackground = styled.div`
  height: 100vh;
  background: black;
  opacity: 0.9;
`;

export default GamePage;
