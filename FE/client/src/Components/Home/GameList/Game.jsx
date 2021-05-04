import React from "react";
import styled from "styled-components";
import Team from "Components/Home/GameList/Team";


const Game = () => {
  return (
    <GameBox>
      <GameNumber>GAME 1</GameNumber>
      <TeamDiv>
        <Team />
        <VsSpan>VS</VsSpan>
        <Team />
      </TeamDiv>
    </GameBox>
  );
};

const GameBox = styled.li`
  display:flex;
  flex-direction:column;
  width:31.25rem;
  height: 3.75rem;
  background:white;
  color:black;
  opacity: 0.7;
  padding:0.6rem 1.7rem;
  border-radius:1.7rem;
  font-size:1.3rem;
`;

const GameNumber = styled.span`
  color:red;
  font-size:0.9rem;
  font-weight: 700;
`;

const TeamDiv = styled.div`
  display:flex;
  justify-content:space-around;
`;

const VsSpan = styled.span`
  color: #48474C;
  font-weight:700;
`;

export default Game;