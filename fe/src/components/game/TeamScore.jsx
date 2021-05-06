import React from "react";
import styled from "styled-components";

const TeamScore = (props) => {
  return (
    <TeamScoreContainer isHome={props.isHome}>
      <p>원정 팀 점수</p>
      <p>원정 팀이름</p>
    </TeamScoreContainer>
  );
};

export default TeamScore;

const TeamScoreContainer = styled.div`
  display: flex;
  flex-direction: ${({ isHome }) => isHome && "row-reverse"};
`;
