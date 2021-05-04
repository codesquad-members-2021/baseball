import styled from 'styled-components';
import { GameContext } from 'util/context.js';

const StyledSituationBoard = styled.div`
  box-shadow: 0 0 0 1px black inset;
`;

function SituationBoard({ className }) {
  return (
    <StyledSituationBoard className={className}>
      
    </StyledSituationBoard>
  )
}

export default SituationBoard
