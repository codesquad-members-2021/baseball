import { PageContext } from "Components/Page";
import React, { useContext } from "react";
import styled from "styled-components";

const Team = ({ teamName, gameId, teamKind, selected }) => {
  const { socket } = useContext(PageContext);

  const handleChoiceTeam = () => {
    socket.emit('choiceTeam', { gameId, teamKind });
  };

  return (
    <TeamLabel>
      <RadioButton
        type="radio"
        name={selected ? selected : "teamName"}
        onClick={handleChoiceTeam}
        disabled={!!selected}
      />
      <TeamName>
        {teamName}
      </TeamName>
    </TeamLabel>
  );
};

const TeamLabel = styled.label`
  width: 50%;
`;

const RadioButton = styled.input`
 display: none;
  &:disabled+span{
    cursor:default;
    color: orchid;
  }
`;

const TeamName = styled.span`
  font-weight: bold;
  font-size: 20px;
  &:hover {
    color: red;
    cursor: pointer;
  }
`;

export default Team;