import React from 'react';
import styled from 'styled-components';
const GameListItem = ({ home, away, game_id, idx }) => {
  return (
    <StyledGameItem>
      <div className='title'>GAME {idx + 1}</div>
      <div className='teams'>
        <div className='teams-name'>{home}</div>
        <div className='teams-vs'>vs</div>
        <div className='teams-name'>{away}</div>
      </div>
    </StyledGameItem>
  );
};

const StyledGameItem = styled.div`
  margin: 0 auto;
  margin-bottom: 1.5rem;
  padding: 1rem 0;
  border-radius: 1rem;
  background-color: rgba(210, 210, 210, 0.95);
  .title {
    color: #ff4545;
    text-align: center;
    font-size: 1.5rem;
    font-weight: 600;
  }
  .teams {
    display: grid;
    grid-template-columns: 1fr 6rem 1fr;
    text-align: center;
    align-items: center;
    padding: 1rem 0;
    &-name {
      font-size: 2rem;
      font-weight: 600;
      cursor: pointer;
      &:hover {
        color: #ff4545;
      }
    }
    &-vs {
      padding-bottom: 0.5rem;
      font-size: 2.5rem;
      font-weight: 600;
      color: #777;
    }
  }
`;

export default GameListItem;
