import { GamePageContext } from "Components/GamePage";
import React, { useContext, useEffect } from "react";
import styled from "styled-components";
import CurrentPlayer from "./CurrentPlayer";

const HeaderRight = () => {
  const {
    inGameData: { away, home },
    attackState,
    sequenceCount,
  } = useContext(GamePageContext);

  return (
    <HeaderRightDiv>
      <CurrentPlayer
        type="투수"
        name={`${
          attackState === "away"
            ? away.find((player) => player.position === "투수").name
            : home.find((player) => player.position === "투수").name
        }`}
        description={`#${
          attackState === "away"
            ? away.find((player) => player.position === "투수").id
            : home.find((player) => player.position === "투수").id
        }`}
      ></CurrentPlayer>
      <CurrentPlayer
        type="타자"
        name={`${
          attackState === "away"
            ? home[sequenceCount].name
            : home[sequenceCount].name
        }`}
        description={"1타석 0안타"}
      ></CurrentPlayer>
    </HeaderRightDiv>
  );
};

const HeaderRightDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  border-left: #e2e2e2 0.1rem solid;
  padding: 0.5rem 0.8rem;
  justify-content: space-around;
  width: 20%;
`;

export default HeaderRight;
