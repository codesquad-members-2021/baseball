import React from 'react';
import styled from 'styled-components';
import TeamList from './TeamList';
import { theme } from '../Style/Theme';

const TitleStyle = styled.div`
  font-size: ${theme.fontSize.XX_large};
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.white};
`;

const MessageStyle = styled.div`
  font-size: ${theme.fontSize.large};
  font-weight: ${theme.fontWeight.normal};
  color: ${theme.colors.white};
`;

const GameTitle = () => {
  return <TitleStyle>BASEBALL GAME ONLINE</TitleStyle>;
};

const MainMessage = () => {
  return <MessageStyle>참가할 게임을 선택하세요!</MessageStyle>;
};

const StartPage = () => {
  return (
    <>
      <GameTitle />
      <MainMessage />
      <TeamList></TeamList>
    </>
  );
};

export default StartPage;
