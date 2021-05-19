import styled from 'styled-components';

import BallCountItem from 'components/GamePlay/playScreen/BallCountItem';

const BallCount = () => {
  return (
    <StyledBallCount>
      <BallCountItem type={'B'} />
      <BallCountItem type={'S'} />
      <BallCountItem type={'O'} />
    </StyledBallCount>
  );
};

export default BallCount;

const StyledBallCount = styled.div`
  display: flex;
  flex-direction: column;
  color: white;
  position: absolute;
  left: 2%;
  top: 3%;
`;
