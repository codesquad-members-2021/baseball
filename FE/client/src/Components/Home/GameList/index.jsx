import React from "react";
import styled from "styled-components";
import Game from "Components/Home/GameList/Game";


const GameList = () => {


  const TeamData = Array.from({ length: 3 });
  return (
    <GameBoxList>
      {TeamData.map(team => {
        return <Game />
      })}
    </GameBoxList>
  );
};

const GameBoxList = styled.ul`
  display:flex;
  flex-direction:column;
  place-items: center;
  margin:2rem auto;
  gap:1rem;

`;

export default GameList;
