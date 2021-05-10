import React from "react";
import styled from "styled-components";
import Team from "./Team";

const Game = ({ gameData }) => {
  return (
    <GameBox>
      <GameNumber>GAME {gameData.id}</GameNumber>
      <TeamDiv>
        <Team name={gameData.awayTeamName} />
        <VsSpan>VS</VsSpan>
        <Team name={gameData.homeTeamName} />
      </TeamDiv>
    </GameBox>
  );
};

const GameBox = styled.li`
  display: flex;
  flex-direction: column;
  width: 31.25rem;
  height: 4.5rem;
  background: white;
  color: black;
  opacity: 0.7;
  padding: 0.6rem 1.7rem;
  border-radius: 1rem;
  font-size: 1.3rem;
`;

const GameNumber = styled.span`
  color: red;
  font-size: 0.9rem;
  font-weight: 700;
`;

const TeamDiv = styled.div`
  display: flex;
  justify-content: space-around;
`;

const VsSpan = styled.span`
  color: #48474c;
  font-weight: 700;
`;

export default Game;
