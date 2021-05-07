import styled from 'styled-components';
import TeamList from './TeamList';
import { theme } from '../Style/Theme';

const GameTitle = () => {
  return <Title>BASEBALL GAME ONLINE</Title>;
};

const MainMessage = () => {
  return <Message>참가할 게임을 선택하세요!</Message>;
};

const StartPage = () => {
  return (
    <>
      <GameTitle />
      <MainMessage />
      <ListWrapper>
        <TeamList />
      </ListWrapper>
    </>
  );
};

export default StartPage;

const Title = styled.div`
  font-size: ${theme.fontSize.XX_large};
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.white};
`;

const Message = styled.div`
  font-size: ${theme.fontSize.large};
  font-weight: ${theme.fontWeight.normal};
  color: ${theme.colors.white};
`;

const ListWrapper = styled.div`
  width: 370px;
  max-height: 295px;
  overflow: hidden;

  &:hover {
    overflow-y: scroll;
  }
`;
