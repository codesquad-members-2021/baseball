import React from 'react';
import styled from 'styled-components';
import BaseballHeaderScore from 'Components/GamePage/GamePageHeader/HeaderLeft/BaseballHeaderScore';

const HeaderLeft = () => {
  return (
    <HeaderLeftWrapper>
      <Title>BASEBALL GAME ONLINE</Title>
      <BaseballHeaderScore />
    </HeaderLeftWrapper>
  );
};

const HeaderLeftWrapper = styled.div`
  margin:auto;
`;

const Title = styled.div`
  font-size: 1.8rem;
  font-weight:700;
  text-align: center;
`;

export default HeaderLeft;
