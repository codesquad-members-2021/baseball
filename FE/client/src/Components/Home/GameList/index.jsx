import React from "react";
import styled from "styled-components";
import Game from "Components/Home/GameList/Game";

const GameList = () => {
  const TeamData = Array.from({ length: 7 });
  return (
    <GameBoxList>
      {TeamData.map((team) => {
        return <Game />;
      })}
    </GameBoxList>
  );
};

const GameBoxList = styled.ul`
  display: flex;
  flex-direction: column;
  place-items: center;
  margin: 2rem auto;
  max-height: 18rem;
  gap: 1rem;
  width: 33rem;
  overflow-y: scroll;
  -ms-overflow-style: none;
  ::-webkit-scrollbar {
    display: none;
  }
`;

export default GameList;
