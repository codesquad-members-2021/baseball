import { PageContext } from "Components/Page";
import React, { useContext } from "react";
import styled from "styled-components";

const Team = ({ teamName, gameId }) => {
  const { playerId, socket } = useContext(PageContext);

  const handleTeamChoice = () => {
    socket.emit('choiceTeam', { playerId, gameId, teamName });
  };

  socket.on('selectedTeam', (teamName) => {

  });

  return (
    <TeamLabel>
      <RadioButton type="radio" name={playerId} onClick={handleTeamChoice} />
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
  &:checked+span{
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
