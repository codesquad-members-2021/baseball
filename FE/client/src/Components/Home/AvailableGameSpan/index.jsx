import React from 'react'
import styled from 'styled-components';

const AvailableGameSpan = () => {
  return (
    <AvailableSpan>참가할 게임을 선택하세요!</AvailableSpan>
  )
}
const AvailableSpan = styled.div`
  margin: 3.5rem 0 0 0;
  color:#fff;
  font-size:1.5rem;
  font-weight: 600;
`;

export default AvailableGameSpan;