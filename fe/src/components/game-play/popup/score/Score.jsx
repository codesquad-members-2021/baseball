import React from 'react';
import styled from 'styled-components';
import useFetch from '../../../../hooks/useFetch';
import ScoreList from './ScoreList';

const Score = ({ score, teamName, gameID }) => {
  const SCORE_URL = `http://52.78.184.142/games/${gameID}/detail-score`;
  //props로 받아올 아이들 1. team 2. player(home or away)
  const ROUND = new Array(12).fill().map((_, idx) => idx + 1);

  // const { data: score } = useFetch(SCORE_URL, 'get');
  console.log(score);
  return (
    score &&
    score.home && (
      <StyledScore>
        <ScoreList dataType='round' data={ROUND} />
        <ScoreList team={teamName.home} dataType='home' data={score.home} isPlayer={true} />
        <ScoreList team={teamName.away} dataType='away' data={score.away} isPlayer={false} />
      </StyledScore>
    )
  );
};

const StyledScore = styled.div`
  width: 70rem;
  min-width: 63rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 2rem 0 0.8rem 0;
  margin: 3rem auto;
  color: #fff;
  border: 3px solid #fff;
`;

const data = {
  home: [1, 0, 0, 0],
  away: [1, 2, 2],
};

export default Score;
