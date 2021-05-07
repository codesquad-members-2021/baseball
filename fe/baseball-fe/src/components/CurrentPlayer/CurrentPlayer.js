import styled from 'styled-components';
import { GameContext } from 'util/context.js';
import { useContext } from 'react';

function CurrentPlayer({ className }) {
  const { gameState } = useContext(GameContext);

  return (
    <StyledCurrentPlayer className={className}>
      <div className="pitcher-info">
        <div>투수</div>
        <div>chan-ho park</div>
      {/* {gameState.currPitcher} */}
      </div>
      <div className="hitter-info">
        <div>타자</div>
        <div>hyun-jin Ryu</div>
      {/* {gameState.currHitter} */}
      </div>
    </StyledCurrentPlayer>
  )
}

export default CurrentPlayer;

const StyledCurrentPlayer = styled.div`
  box-shadow: 0 0 0 1px black inset;
  padding: 1rem;

  .pitcher-info {
    margin-bottom: 1rem;

  }

  .hitter-info {
  }
`;
