import React from "react";
import styled from "styled-components";

const TeamScore = ({ isHome, team, score }) => {
  return (
    <TeamScoreContainer isHome={isHome}>
      <p>{score}</p>
      <p>{team.name}</p>
    </TeamScoreContainer>
  );
};

export default TeamScore;

const TeamScoreContainer = styled.div`
  display: flex;
  flex-direction: ${({ isHome }) => !isHome && "row-reverse"};
`;
