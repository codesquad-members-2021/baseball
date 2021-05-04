import React from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';

const StyledCurrentPlayer = styled.div`
  box-shadow: 0 0 0 1px black inset;
`;

function CurrentPlayer({ className }) {
  return (
    <StyledCurrentPlayer className={className}>
      
    </StyledCurrentPlayer>
  )
}

export default CurrentPlayer;
