import styled from 'styled-components';
import { useState, useEffect, useContext } from 'react';
import { GameContext } from 'util/context.js';

function BroadCast({ className }) {
  const { gameState } = useContext(GameContext);
  const [ actionList, setActionList ] = useState(gameState.latestAction);

  useEffect(() => {
    setActionList(actionList);
  }, [actionList]);

  return (
    <StyledBroadCast className={className}>
      <div className="curr-hitter">
        {gameState.currHitter}
      </div>
      <div className="hitter-record">{}</div>
    </StyledBroadCast>
  )
}

export default BroadCast;

const StyledBroadCast = styled.div`
  box-shadow: 0 0 0 1px black inset;

  .curr-hitter {
    border: 2px solid green;
  }

  .hitter-record {
    border: 2px solid blue;
  }
`;