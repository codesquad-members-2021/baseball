import Caption from '../components/startScreen/Caption';
import GameList from '../components/startScreen/GameList';
import Title from '../components/startScreen/Title';
import styled from 'styled-components';

const StartScreen = (props) => {
  return (
    <StartDiv>
      <Title />
      <Caption />
      <GameList />
    </StartDiv>
  );
};

const StartDiv = styled.div`
  margin: 0 auto;
  max-width: 1440px;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

export default StartScreen;
