import React from 'react';
import styled from 'styled-components';

const BallCount = ({ ballCount: { strike, ball, out } }) => {
  return (
    <StyleBallCount>
      <div className="couters strike">
        <div>S</div>
        {createBallCountTag(strike)}
      </div>
      <div className="couters ball">
        <div>B</div>
        {createBallCountTag(ball)}
      </div>
      <div className="couters out">
        <div>O</div>
        {createBallCountTag(out)}
      </div>
    </StyleBallCount>
  )
}

function createBallCountTag(count) {
  const result = [];
  for(let i = 0; i < count; i++) {
    result.push(<div/>);
  }
  return result;
}

const StyleBallCount = styled.div`
  color:#fff;
  font-weight:600;
  .couters {
    display: flex;
    margin-bottom:0.5rem;
    & > div {
      font-size: 1.5rem;
      margin-right: 0.5rem;
      width: 1.5rem;
      height: 1.5rem;
      line-height: 1.3rem;
    }
    & > div:not(:first-child) {
      border-radius: 50%;
      width: 1.5rem;
      height: 1.5rem;
    }
  }
  .strike{
    & > div:not(:first-child) {
      background-color:yellow;
    }
  }
  .ball{
    & > div:not(:first-child) {
      background-color:green;
    }
  }
  .out{
    & > div:not(:first-child) {
      background-color:red;
    }
  }
`;

export default BallCount;