import Caption from '../components/Caption';
import GameList from '../components/GameList';
import Title from '../components/Title';
import styled from 'styled-components';

const StartDiv = styled.div`
  margin: 0 auto;
  max-width: 1440px;
  display: flex;
  align-items: center;
  flex-direction: column;
`;
const StartScreen = (props) => (
  <StartDiv>
    <Title />
    <Caption />
    <GameList />
  </StartDiv>
);

export default StartScreen;
