import { useState } from "react";
import styled from "styled-components";
import Title from "../shared/Title";
import Message from "./Message";
import Teams from "./Teams";

const mockData = [
  {
    id: 0,
    name: "Bears",
  },
  {
    id: 1,
    name: "Landers",
  },
  {
    id: 2,
    name: "Twins",
  },
  {
    id: 3,
    name: "Giants",
  },
  {
    id: 4,
    name: "Eagles",
  },
  {
    id: 5,
    name: "Tigers",
  },
  {
    id: 6,
    name: "Lions",
  },
  {
    id: 7,
    name: "Dinos",
  },
];

const Main = () => {
  const [teamList, setTeamList] = useState(mockData);
  const setMatches = (teamList) => {
    const result = [];
    let match = [];
    while (teamList.length) {
      if (match.length < 2) {
        const i = parseInt(Math.random() * teamList.length);
        match.push(teamList[i]);
        teamList.splice(i, 1);
      }
      if (match.length >= 2) {
        result.push(match);
        match = [];
      }
    }
    return result;
  };

  return (
    <>
      <Title />
      <Message />
      <TeamMatchContainer>
        {setMatches([...teamList]).map((teamSet) => {
          return <Teams teamSet={teamSet} />;
        })}
      </TeamMatchContainer>
    </>
  );
};

export default Main;

const TeamMatchContainer = styled.div`
  border: 1px solid red;
  display: flex;
  flex-direction: column;
`;
