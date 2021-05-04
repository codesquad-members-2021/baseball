import React from 'react';
import styled from 'styled-components';
import ScoreList from './GameScoreList';

const GameScore = (props) => {
  //props로 받아올 아이들 1. team 2. player(home or away)
  const ROUND = new Array(12).fill().map((_, idx) => idx + 1);

  return (
    <StyleGameScore>
      <ScoreList dataType='round' data={ROUND} />
      <ScoreList team='Captain' dataType='home' data={data.home} isPlayer={true} />
      <ScoreList team='Marvel' dataType='away' data={data.away} isPlayer={false} />
    </StyleGameScore>
  );
};

const StyleGameScore = styled.div`
  width: 80%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 1rem 0;
  margin: 3rem auto;
  color: #fff;
  border: 3px solid #fff;
`;

const data = {
  home: [1, 0, 0, 0],
  away: [1, 2, 2],
};

export default GameScore;
