import styled from 'styled-components';
import { GameContext } from 'util/context.js';

import BallCount from './BallCount.js';
import Field from './Field.js';

function SituationBoard({ className }) {
  return (
    <StyledSituationBoard className={className}>
      <BallCount/>
      <div className='inning'></div>
      <button className='pitch-btn'>PITCH</button>
      <Field/>
    </StyledSituationBoard>
  )
}

export default SituationBoard;

const StyledSituationBoard = styled.div`
  box-shadow: 0 0 0 1px black inset;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  position: relative;
  
  .inning {
    box-shadow: 0 0 0 1px red inset;
    position: absolute;
    align-self: flex-end;
    width: 100px;
    height: 100px;
  }

  .pitch-btn {
    
  }
`;
