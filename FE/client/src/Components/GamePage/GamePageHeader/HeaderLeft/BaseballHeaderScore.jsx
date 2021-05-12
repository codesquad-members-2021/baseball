import { GamePageContext } from 'Components/GamePage';
import React, { useContext } from 'react';
import styled, { css } from 'styled-components';


const BaseballHeaderScore = () => {
  const { teamState: { home, away } } = useContext(GamePageContext);

  return (
    <TeamDiv>
      <Team player={home.isMyTeam}>{home.teamName}</Team>
      <Score>1</Score>
      <VsSpan>vs</VsSpan>
      <Score>5</Score>
      <Team player={away.isMyTeam}>{away.teamName}</Team>
    </TeamDiv>
  );
};

const TeamDiv = styled.div`
  display:flex;
  justify-content:space-around;
  font-size: 3.3rem;
  gap:2.5rem;
  font-weight:700;
`;

const Team = styled.span`
  ${({ player }) => player && css`
    &::after{
      content:"Player";
      display: block;
      color: red;
      font-size:1.5rem;
      text-align: center;
    }
  `}

`;
const Score = styled.span`
  `;

const VsSpan = styled.span`
  color: #7D7D7D;
  font-weight: 700;
`;


export default BaseballHeaderScore;
