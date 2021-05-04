import React from 'react';
import styled from 'styled-components';

const GameScoreList = ({ team, dataType, data, isPlayer }) => {
  const isRound = dataType === 'round';

  const scoreList = new Array(12).fill('');

  data.forEach((v, idx) => (scoreList[idx] = v));
  isRound ? scoreList.push('R') : scoreList.push(data.reduce((acc, cur) => acc + cur));

  const scoreDivList = scoreList.map((score, idx, arr) => (
    <div
      key={idx + 1}
      className={idx === arr.length - 1 && !isRound ? 'score last-score' : 'score'}
    >
      {score}
    </div>
  ));

  return (
    <StyleScoreList isRound={isRound}>
      <div className='team-wrapper'>
        <div className='team'>{team ? team : ''}</div>
        {isPlayer && <div className='turn'>player</div>}
      </div>
      <div className='score-list'>{scoreDivList}</div>
    </StyleScoreList>
  );
};

const StyleScoreList = styled.div`
  display: flex;

  .team-wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-right: 2rem;
    .team {
      width: 5rem;
      font-size: 1.5rem;
      font-weight: 600;
    }
    .turn {
      color: #ff4545;
      font-weight: 600;
    }
  }
  .score-list {
    border-bottom: ${({ isRound }) => isRound && '3px solid #fff'};
    /* margin-bottom: ${({ isRound }) => isRound && '1rem'}; */
  }
  .score {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 1.5rem;
    font-weight: 700;
    width: 3rem;
    height: 3rem;
    margin-right: 1rem;
  }
  .last-score {
    color: #ff4545;
  }
  .score-list {
    display: flex;
  }
`;

export default GameScoreList;
