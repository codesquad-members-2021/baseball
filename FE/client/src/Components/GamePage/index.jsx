import React from "react";
import GamePageHeader from "Components/GamePage/GamePageHeader";
import MainContainer from "./MainContainer";
import TopPopup from 'Components/GamePage/TopPopup';
import styled from "styled-components";

const GamePage = () => {
  return (
    <GamePageBackground>
      {/*<TopPopup />*/}
      <GamePageHeader />
      <MainContainer />
    </GamePageBackground>
  );
};

const GamePageBackground = styled.div`
  height: 100vh;
  background: black;
  opacity: 0.9;
`;

export default GamePage;
