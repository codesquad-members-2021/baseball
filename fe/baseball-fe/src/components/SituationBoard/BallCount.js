import styled from 'styled-components';

function BallCount() {
  const renderStrike = () => {

  }

  const renderBall = () => {

  }

  const renderOut = () => {

  }

  return (
    <StyledBallCount>
      <ul className='strike'>
        S
      </ul>
      <ul className='ball'>
        B
      </ul>
      <ul className='out'>
        O
      </ul>
    </StyledBallCount>
  )
}

export default BallCount;

const StyledBallCount = styled.div`
  box-shadow: 0 0 0 1px red inset;
  align-self: flex-start;
`;

const Count = styled.div`
  width: 1rem;
  height: 1rem;
  border-radius: 9999px;

  .strike {
    background-color: yellow;
  }

  .ball {
    background-color: green;
  }

  .out {
    background-color: red;
  }
`;