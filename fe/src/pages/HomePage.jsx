import styled from "styled-components";

import Responsive from "../components/common/Responsive.jsx";
import GameMessage from "../components/common/GameMessage.jsx";

import GameList from "../components/common/GameList.jsx";

const HomePage = () => {

  // const handleGameMessage
  return (
    <>
      <HomePageLayout>
        <Header> BASEBALL GAME ONLINE </Header>
        <GameMessage />
        <GameList></GameList>
      </HomePageLayout>
      
      <HomePageBackgroundLayer>
        <HomePageBlackLayer />
      </HomePageBackgroundLayer>
    </>
  );
};

const HomePageBlackLayer = styled.div`
  width: 100%;
  height: 100vh;
  position: absolute;
  top: 0;
  
  background-color: black;
  opacity: 70%;
`
const HomePageBackgroundLayer = styled.div`
  width: 100%;
  height: 100%;

  position: absolute;
  top: 0;
  
  z-index: -1;
  background-image: url("https://user-images.githubusercontent.com/13144573/117235633-0cd13f80-ae62-11eb-948c-534f55095e0d.png");
  background-size: cover;
`;

const HomePageLayout = styled(Responsive)``;

const Header = styled.div`
  width: 100%;
  color: white;
  font-size: 5rem;
  font-weight: bold;

  padding-top: 10%;

  display: flex;
  justify-content: center;
`;

export default HomePage;
