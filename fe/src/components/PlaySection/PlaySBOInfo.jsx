import styled from "styled-components";

const setActiveState = count => {
  const initActiveState = Array(3).fill(false);
  for (let i = 0; i < count; i++) initActiveState[i] = true;
  return initActiveState;
};

const SBOProperties = {
  strike: {
    color: "yellow",
    title: "S",
  },
  ball: {
    color: "green",
    title: "B",
  },
  out: {
    color: "red",
    title: "O",
  },
};

const PlaySBOInfo = ({ SBOState }) => {
  const { strike, ball, out } = SBOState;

  return (
    <SBOInfoLayout>
      <Row>
        <BallType>{SBOProperties.strike.title}</BallType>
        {setActiveState(strike).map((x, idx) => (
          <Light
            key={`strike-${idx}`}
            active={x}
            bgColor={SBOProperties.strike.color}
          />
        ))}
      </Row>
      <Row>
        <BallType>{SBOProperties.ball.title}</BallType>
        {setActiveState(ball).map((x, idx) => (
          <Light
            key={`ball-${idx}`}
            active={x}
            bgColor={SBOProperties.ball.color}
          />
        ))}
      </Row>
      <Row>
        <BallType>{SBOProperties.out.title}</BallType>
        {setActiveState(out).map((x, idx) => (
          <Light
            key={`out-${idx}`}
            active={x}
            bgColor={SBOProperties.out.color}
          />
        ))}
      </Row>
    </SBOInfoLayout>
  );
};

const SBOInfoLayout = styled.div`
  position: absolute;
  top: 4%;
  left: 4%;
`;

const BallType = styled.div`
  width: 20%;
  padding: 0px 10px;
  font-weight: bold;
  text-align: center;

  color: white;
  font-size: 3.4rem;

  @media (max-width: 1200px) {
    font-size: 2rem;
  }
  @media (max-width: 768px) {
    font-size: 1rem;
  }
`;

const Row = styled.div`
  display: flex;
`;

const Light = styled.div`
  display: inline-block;
  width: 3rem;
  height: 3rem;
  background-color: ${props => props.active && props.bgColor};
  border: 1px solid white;
  border-radius: 50%;

  & + & {
    margin-left: 2%;
  }

  @media (max-width: 1200px) {
    width: 2rem;
    height: 2rem;
  }
  @media (max-width: 768px) {
    width: 1rem;
    height: 1rem;
  }
`;
export default PlaySBOInfo;
