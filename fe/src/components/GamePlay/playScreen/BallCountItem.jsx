import { useContext } from 'react';
import styled from 'styled-components';
import { v4 as uuidv4 } from 'uuid';

import { gamePlayContext } from 'components/GamePlay/GamePlay';

const BallCountItem = ({ type }) => {
  const { ballCountState } = useContext(gamePlayContext);

  return (
    <StyledCountItem>
      <BsoSpan>{type}</BsoSpan>
      {Array(ballCountState[type])
        .fill(type)
        .map((v) => (
          <StyledCount type={v} key={uuidv4()} />
        ))}
    </StyledCountItem>
  );
};

export default BallCountItem;

const BsoSpan = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  width: 2rem;
  line-height: 1;
  padding-bottom: 0.6rem;
`;

const StyledCountItem = styled.div`
  display: flex;
  align-items: center;
`;
const StyledCount = styled.div`
  margin-left: 1rem;
  border-radius: 50%;
  width: 2rem;
  height: 2rem;
  background-color: ${(props) => {
    switch (props.type) {
      case 'B':
        return props.theme.colors.ballGreen;
      case 'S':
        return props.theme.colors.ballYellow;
      case 'O':
        return props.theme.colors.ballRed;
      default:
    }
  }};
`;
