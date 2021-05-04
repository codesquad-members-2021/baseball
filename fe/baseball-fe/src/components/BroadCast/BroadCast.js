import React from 'react';
import styled from 'styled-components';

const StyledBroadCast = styled.div`
  box-shadow: 0 0 0 1px black inset;
`;

function BroadCast({ className }) {
  return (
    <StyledBroadCast className={className}>
      
    </StyledBroadCast>
  )
}

export default BroadCast;
