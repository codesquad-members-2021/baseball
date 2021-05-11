import {useState, useEffect} from 'react';
import styled from 'styled-components';

const ScoreBoard = (props) => {
  console.log(props.className)
  return (
    <ScoreBoardLayout className={props.className}>
      <ScoreBoardRow>
        <ScoreBoardTitle>BASEBALL GAME ONLINE</ScoreBoardTitle>
      </ScoreBoardRow>
      <ScoreBoardRow>
        <ScoreBoardMatch>
          <ScoreBoardTeam>AAA</ScoreBoardTeam>
          <ScoreBoardPoint>1</ScoreBoardPoint>
          <ScoreBaordVersus />
          <ScoreBoardPoint>2</ScoreBoardPoint>
          <ScoreBoardTeam>BBB</ScoreBoardTeam>
        </ScoreBoardMatch>
      </ScoreBoardRow>
    </ScoreBoardLayout>
  );
};

const ScoreBoardLayout = styled.section`
  width: 100%;
  
  display: flex;
  flex-direction: column;
  justify-content: center;
`;

const ScoreBoardRow = styled.div`
  width: 100%;
  
  display: flex;
  justify-content: center;
  align-items: center;

  & + & {
    padding-top: 5%;
  } 
`;

const ScoreBoardTitle = styled.span`
  /* display:flex;  */
  font-size: 4rem;
`

const ScoreBoardMatch = styled.div`
  width: 100%;
  padding: 0 10%;
  box-sizing: border-box;

  display: flex;
  align-items: baseline;
  justify-content: space-evenly;
`

const ScoreBoardTeam = styled.span`
  font-size: 8rem;
`
const ScoreBoardPoint = styled.span`
  font-size: 8rem;
`
const ScoreBaordVersus = styled.span`
  font-size: 4rem;
  color: grey;
  ::after {
    content: "VS"
  }
` 
export default ScoreBoard;
