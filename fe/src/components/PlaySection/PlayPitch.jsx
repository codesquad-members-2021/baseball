import styled from "styled-components";

const pitchResultList = ["⚡️STRIKE⚡️", "💥BALL💥", "☠️OUT☠️"];

const judge = ({ SBOState, dispatch }) => {
  const { strike, ball, out } = SBOState;

  if (strike === 3) {
    dispatch({ type: "OUT" });
    dispatch({ type: "SB_RESET" });
  }
  if (ball === 4) dispatch({ type: "SB_RESET" });
  if (out === 3) dispatch({ type: "TOTAL_RESET" });
};

const getRandomPitchResult = () => {
  const SBO = ["STRIKE", "BALL"];
  const radomNumber = Math.floor(Math.random() * 2);
  return SBO[`${radomNumber}`];
};

const PlayPitch = ({ SBOState, dispatch }) => {
  const updateSBO = () => {
    const pitchResult = getRandomPitchResult(SBOState);
    dispatch({ type: pitchResult });
    judge({ SBOState, dispatch });
  };

  return (
    <>
      <Ball />
      <PitchResult>{pitchResultList[0]}</PitchResult>
      <PitchButton onClick={updateSBO}>PITCH</PitchButton>
    </>
  );
};

const PitchResult = styled.div`
  position: absolute;
  width: 400px;
  top: 40%;
  left: 30%;
  text-align: center;
  font-size: 3rem;
  font-weight: bold;
  color: white;
`;

const PitchButton = styled.div`
  position: absolute;
  top: 60%;
  left: 40%;
  width: 150px;
  padding: 10px;
  border: 1px solid white;
  border-radius: 30px;
  text-align: center;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  cursor: pointer;

  &:hover {
    transform: scale(1.1);
  }
`;

const Ball = styled.img.attrs({
  src: `${"http://www.bellsnwhistles.com/6spia/1asp169.gif"}`,
})`
  position: absolute;
  top: 40%;
  left: 39%;
  width: 200px;
`;
export default PlayPitch;
