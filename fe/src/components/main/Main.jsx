import { useEffect, useState } from "react";
import styled from "styled-components";
import Title from "../shared/Title";
import Message from "./Message";
import Teams from "./Teams";

const teamList = [
  [
    { id: 1, name: "Captain" },
    { id: 3, name: "Twins" },
  ],
  [
    { id: 5, name: "Rockets" },
    { id: 2, name: "Marvel" },
  ],
  [
    { id: 4, name: "Tigers" },
    { id: 6, name: "Dodgers" },
  ],
];

const Main = () => {
  // useEffect(() => {
  //   fetch("http://ec2-15-165-82-124.ap-northeast-2.compute.amazonaws.com:8080/totalTeamList")
  //     .then((res) => res.json())
  //     .then((json) => setTeamList(json));
  // }, []);

  // const setMatches = (teamList) => {
  //   const result = [];
  //   let match = [];
  //   while (teamList.length) {
  //     if (match.length < 2) {
  //       const i = parseInt(Math.random() * teamList.length);
  //       match.push(teamList[i]);
  //       teamList.splice(i, 1);
  //     }
  //     if (match.length >= 2) {
  //       result.push(match);
  //       match = [];
  //     }
  //   }
  //   return result;
  // };

  return (
    <>
      <Title />
      <Message />
      <TeamMatchContainer>
        {/* {teamList &&
          setMatches([...teamList]).map((teamSet) => {
            return <Teams teamSet={teamSet} />;
          })} */}
        {[...teamList].map((teamSet) => {
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
