import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import styled from "styled-components";

const AttackDefendStatus = () => {
  const { roundCount, attackState, teamState } = useContext(GamePageContext);

  return (
    <ADstatusDiv>{`${roundCount}회차 ${
      teamState[attackState].isMyTeam ? "공격" : "수비"
    }`}</ADstatusDiv>
  );
};

const ADstatusDiv = styled.div`
  font-size: 1.5rem;
  font-weight: bold;
  padding: 2rem 2rem;
`;
export default AttackDefendStatus;