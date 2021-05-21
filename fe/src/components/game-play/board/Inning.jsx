import React from 'react';
import styled from 'styled-components';
const Inning = ({ inning: { turn, round }, isHome }) => {
    return <StyledInning>{round}회{turn ? '초' : '말'} {(isHome && turn) || (!isHome && !turn) ? '공격' : '수비'}</StyledInning>
}

const StyledInning = styled.div`
  font-size: 1.5rem;
  font-weight: 600;
  color: #fff;
  text-align: right;
`;

export default Inning;