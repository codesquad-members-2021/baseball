import React from "react";
import styled from "styled-components";
import GameList from "./GameList";
import AvailableGameSpan from "./AvailableGameSpan";
import BackgroundImage from "Images/Background.jpg";

const Home = () => {
  return (
    <Background>
      <Header>BASEBALL GAME ONLINE</Header>
      <AvailableGameSpan />
      <GameList />
    </Background>
  );
};

const Header = styled.div`
  margin: 4rem 0 0 0;
  color: #fff;
  font-size: 3rem;
  font-weight: 700;
`;

const Background = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
    url(${BackgroundImage});
  text-align: center;
  background-repeat: no-repeat;
  background-size: 100% 100%;
`;
export default Home;