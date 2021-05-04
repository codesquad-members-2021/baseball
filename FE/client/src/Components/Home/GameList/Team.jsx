import React from "react";
import styled from "styled-components";

const Team = () => {
  return (
    <TeamName>팀이름</TeamName>
  );
};

const TeamName = styled.span`
  font-weight:bold;
  font-size: 20px;
  &:hover{
    color: #ff000d;
    cursor: pointer;
  }
`;



export default Team;
