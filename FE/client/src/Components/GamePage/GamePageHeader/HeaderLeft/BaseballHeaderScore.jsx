import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import styled, { css } from "styled-components";

const BaseballHeaderScore = () => {
  const {
    teamState: { home, away },
    teamScore
  } = useContext(GamePageContext);

  return (
    <TeamDiv>
      <Team player={home.isMyTeam}>{home.teamName}</Team>
      <Score>{teamScore.home}</Score>
      <VsSpan>vs</VsSpan>
      <Score>{teamScore.away}</Score>
      <Team player={away.isMyTeam}>{away.teamName}</Team>
    </TeamDiv>
  );
};

const TeamDiv = styled.div`
  display: flex;
  justify-content: space-around;
  font-size: 2.3rem;
  gap: 2.5rem;
  font-weight: 700;
`;

const Team = styled.span`
  ${({ player }) =>
    player &&
    css`
      &::after {
        content: "Player";
        display: block;
        color: red;
        font-size: 1.5rem;
        text-align: center;
      }
    `}
`;
const Score = styled.span``;

const VsSpan = styled.span`
  color: #7d7d7d;
  font-weight: 700;
`;

export default BaseballHeaderScore;
