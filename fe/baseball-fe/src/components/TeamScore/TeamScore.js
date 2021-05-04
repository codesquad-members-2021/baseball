import React from 'react';
import styled from 'styled-components';

const StyledTeamScore = styled.div`
  box-shadow: 0 0 0 1px black inset;
`;

function TeamScore({ className }) {
  return (
    <StyledTeamScore className={className}>
      
    </StyledTeamScore>
  )
}

export default TeamScore
