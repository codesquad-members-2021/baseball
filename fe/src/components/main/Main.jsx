import { useEffect, useState } from "react";
import styled from "styled-components";
import Title from "../shared/Title";
import Message from "./Message";
import Teams from "./Teams";
import axios from "axios";

const Main = () => {
  const [teamList, setTeamList] = useState([]);

  useEffect(() => {
    axios.get("http://ec2-15-165-205-188.ap-northeast-2.compute.amazonaws.com:8080").then((res) => console.log(res.data));
  }, [teamList]);

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
