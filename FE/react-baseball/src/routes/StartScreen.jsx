import Caption from "../components/Caption";
import GameList from "../components/GameList";
import Title from "../components/Title";
import styled from "styled-components";

const StartDiv = styled.div`
  margin: 0 auto;
  max-width: 1440px;
  display: flex;
  align-items: center;
  flex-direction: column;
`;
const StartScreen = (props) => (
  <StartDiv>
    <h1>start 화면</h1>
    <Title />
    <Caption />
    <GameList />
  </StartDiv>
);

export default StartScreen;
