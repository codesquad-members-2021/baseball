import styled from 'styled-components';
import { useState, useEffect } from 'react';
import { GameContext } from 'util/context.js';
import { useContext } from 'react';
import useFetch from 'util/hook/useFetch.js';

function CurrentPlayer({ className }) {
  const { gameState } = useContext(GameContext);
  // const [batter, setBatter] = useState({...gameState.batter});

  // useEffect(() => {
  //   if (gameState.batter === null) 

  // }, [gameState.batter]);

  return (
    <StyledCurrentPlayer className={className}>
      <div className="pitcher">
        <div>투수</div>
        <div>
          {gameState.pitcher.name}
          <span>{` #${gameState.pitcher.uniform_number}`}</span>
        </div>
      </div>
      <div className="batter">
        <div>타자</div>
        <div>
          {gameState.batter.name}
          <span>{` #${gameState.batter.uniform_number}`}</span>
        </div>
      </div>
    </StyledCurrentPlayer>
  )
}

export default CurrentPlayer;

const StyledCurrentPlayer = styled.div`
  box-shadow: 0 0 0 1px black inset;
  padding: 1rem;

  .pitcher {
    margin-bottom: 1rem;
  }

  .batter {
  }
`;
