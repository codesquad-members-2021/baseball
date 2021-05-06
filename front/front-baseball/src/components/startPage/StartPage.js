import styled, { css } from "styled-components";
import MenuBox from "./MenuBox";
const StartPage = () => {
  return (
    <StartPageWrapper>
      <Title>BASEBALL GAME ONLINE</Title>
      <MenuBox />
    </StartPageWrapper>
  );
};
const Title = styled.h1`
  font-size: 4rem;
  margin: 2rem 0;
  color: white;
`;
const StartPageWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export default StartPage;
