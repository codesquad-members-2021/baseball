import React from 'react';
import styled from 'styled-components';
import { IoBaseballOutline } from 'react-icons/io5';

const ScoreList = ({ team, dataType, data, isPlayer }) => {
  const isInRound = dataType === 'round';
  const scoreList = new Array(12).fill('');

  data.forEach((v, idx) => (scoreList[idx] = v));
  isInRound ? scoreList.push('R') : scoreList.push(data.reduce((acc, cur) => acc + cur, 0));

  const scoreDivList = scoreList.map((score, idx, arr) => (
    <div
      key={idx + 1}
      className={idx === arr.length - 1 && !isInRound ? 'score last-score' : 'score'}
    >
      {score}
    </div>
  ));

  return (
    <StyledScoreList isInRound={isInRound}>
      <div className='team-wrapper'>
        <div className='team'>
          {isPlayer && <IoBaseballOutline className='baseball' />}
          <div>{team || ''}</div>
        </div>
        {isPlayer && <div className='turn'>player</div>}
      </div>
      <div className='score-list'>{scoreDivList}</div>
    </StyledScoreList>
  );
};

const StyledScoreList = styled.div`
  display: flex;

  .team-wrapper {
    margin-right: 2rem;
    .team {
      position: relative;
      width: 5rem;
      font-size: 1.5rem;
      font-weight: 700;
      .baseball {
        position: absolute;
        top: 0.2rem;
        left: -1.7rem;
        margin-right: 0.2rem;
      }
      span {
        text-align: center;
      }
    }
    .turn {
      color: #ff4545;
      font-weight: 600;
      text-align: center;
    }
  }

  .score-list {
    border-bottom: ${({ isInRound }) => isInRound && '3px solid #fff'};
    margin-bottom: ${({ isInRound }) => (isInRound ? '1rem' : '0.3rem')};
  }
  .score {
    display: flex;
    justify-content: center;
    font-size: 1.5rem;
    font-weight: 700;
    width: 3rem;
    height: ${({ isInRound }) => (isInRound ? '2.7rem' : '3rem')};
    margin-right: 1rem;
  }
  .last-score {
    color: #ff4545;
  }
  .score-list {
    display: flex;
  }
`;

export default ScoreList;
