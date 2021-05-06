import React from "react";
import styled from "styled-components";

const CurrentPlayer = (props) => {
  return (
    <>
      <PlayerType>{props.type}</PlayerType>
      <PlayerNameDes>
        <PlayerName>{props.name}</PlayerName>
        <PlayerDescription>{props.description}</PlayerDescription>
      </PlayerNameDes>
    </>
  );
};

const PlayerType = styled.div`
  font-size: 1.1rem;
`;

const PlayerName = styled.div`
  font-size: 1rem;
  color: #9ee6e6;
  margin-right: 0.7rem;
`;

const PlayerDescription = styled.span`
  color: #47abc4;
  margin-right: 2rem;
`;

const PlayerNameDes = styled.div`
  display: flex;
`;
export default CurrentPlayer;
