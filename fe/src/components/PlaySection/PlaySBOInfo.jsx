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
  top: 6%;
  left: 1%;
`;

const BallType = styled.div`
  width: 20%;
  padding: 0px 10px;
  font-weight: bold;
  text-align: center;

  color: white;
  font-size: 2.2rem;
`;

const Row = styled.div`
  display: flex;
`;

const Light = styled.div`
  display: inline-block;
  width: 2rem;
  height: 2rem;
  background-color: ${props => props.active && props.bgColor};
  border: 1px solid white;
  border-radius: 50%;

  & + & {
    margin-left: 2%;
  }
`;
export default PlaySBOInfo;
