import { useState } from 'react';
import styled from 'styled-components';
import TeamList from './TeamList';
import { theme } from '../Style/Theme';

const GameTitle = () => {
  return <Title>BASEBALL GAME ONLINE</Title>;
};

const StartPage = () => {
  const [message, setMessage] = useState('참가할 게임을 선택하세요!');

  const MainMessage = () => {
    return <Message>{message}</Message>;
  };

  return (
    <>
      <GameTitle />
      <MainMessage />
      <div>
        <ListWrapper>
          <TeamList setMessage={setMessage} />
        </ListWrapper>
      </div>
    </>
  );
};

export default StartPage;

const Title = styled.div`
  font-size: ${theme.fontSize.XX_large};
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.white};
  text-align: center;
  margin: 20px 0;
`;

const Message = styled.div`
  font-size: ${theme.fontSize.large};
  font-weight: ${theme.fontWeight.normal};
  color: ${theme.colors.white};
  text-align: center;
  margin: 10px 0;
`;

const ListWrapper = styled.div`
  width: 370px;
  margin: 0 auto;
  max-height: 295px;
  overflow: hidden;

  &:hover {
    overflow-y: scroll;
  }
`;
