import React from "react";
import styled from "styled-components";

const Team = ({ name }) => {
  return <TeamName>{name}</TeamName>;
};

const TeamName = styled.span`
  font-weight: bold;
  font-size: 20px;
  &:hover {
    color: #ff000d;
    cursor: pointer;
  }
`;

export default Team;
