import { useContext } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';

function BallCount() {
  const { gameState } = useContext(GameContext);

  const renderStrike = () => {
    return [...Array(gameState.ballCount.strike).keys()].map((_, idx) =>
      <Count key={idx} className='strike'/>
    );
  }

  const renderBall = () => {
    return [...Array(gameState.ballCount.ball).keys()].map((_, idx) =>
      <Count key={idx} className='ball'/>
    );
  }

  const renderOut = () => {
    return [...Array(gameState.ballCount.out).keys()].map((_, idx) =>
      <Count key={idx} className='out'/>
    );
  }

  return (
    <StyledBallCount>
      <CountList>
        S
        {renderStrike()}
      </CountList>
      <CountList>
        B
        {renderBall()}
      </CountList>
      <CountList>
        O
        {renderOut()}
      </CountList>
    </StyledBallCount>
  )
}

export default BallCount;

const StyledBallCount = styled.div`
  box-shadow: 0 0 0 1px red inset;
  align-self: flex-start;
`;

const CountList = styled.ul`
  display: flex;
  list-style: none;
  padding-left: 1rem;
`;

const Count = styled.li`
  width: 1rem;
  height: 1rem;
  border-radius: 9999px;

    margin-left: 0.5rem;

  &.strike {
    background-color: yellow;
  }

  &.ball {
    background-color: green;
  }

  &.out {
    background-color: red;
  }
`;