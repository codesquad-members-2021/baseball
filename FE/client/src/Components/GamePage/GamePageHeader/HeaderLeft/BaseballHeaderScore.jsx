import React from 'react';
import styled, { css } from 'styled-components';

const BaseballHeaderScore = () => {
  return (
    <TeamDiv>
      <Team player>Captain</Team>
      <Score>1</Score>
      <VsSpan>vs</VsSpan>
      <Score>5</Score>
      <Team>Marvel</Team>
    </TeamDiv>
  );
};

const TeamDiv = styled.div`
  display:flex;
  justify-content:space-around;
  font-size: 4rem;
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
