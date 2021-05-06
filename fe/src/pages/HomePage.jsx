import styled from "styled-components";

import Responsive from "../components/common/Responsive.jsx";
import GameMessage from "../components/common/GameMessage.jsx";
import Header from "../components/common/Header.jsx";
import GameList from "../components/common/GameList.jsx";

// 1. 합성의 형태

// 2. HOC의 형태
const HomePage = () => {
  return (
    <>
      <HomepageBackgroundLayer />
      <HomePageLayout>
        <Header />
        <GameMessage />
        <GameList></GameList>
      </HomePageLayout>
    </>
  );
};

const HomepageBackgroundLayer = styled.div`
  position: absolute;
  width: 100%;
  height: 100vh;
  z-index: -1;
  background-image: url("https://user-images.githubusercontent.com/13144573/117235633-0cd13f80-ae62-11eb-948c-534f55095e0d.png");
  filter: grayscale(80%);
  background-size: cover;
`;

const HomePageLayout = styled(Responsive)``;

export default HomePage;
