import React from 'react';
import reactDom from 'react-dom';
import styled from 'styled-components';

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

`;
const Score = styled.span`
`;

const VsSpan = styled.span`
  color: #48474C;
  font-weight:700;
`;


export default BaseballHeaderScore;
