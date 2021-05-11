import styled from "styled-components";
import { useState, useEffect } from "react";
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
  const SB = ["STRIKE", "BALL"];
  const radomNumber = Math.floor(Math.random() * 2);
  return SB[`${radomNumber}`];
};
let playSectionWidth, playSectionHeight;

const PlayPitch = ({ SBOState, dispatch }) => {
  const updateSBO = () => {
    const pitchResult = getRandomPitchResult();
    dispatch({ type: pitchResult }); //strike 3이랑 ball 4가 화면에 보임 ...
    judge({ SBOState, dispatch });
  };

  return (
    <PitchButtonLayout>
      {/* <Ball /> */}
      {/* <PitchResult>{pitchResult}</PitchResult> */}
      <PitchButton _left={playSectionWidth} onClick={updateSBO}>
        PITCH
      </PitchButton>
    </PitchButtonLayout>
  );
};

const PitchButtonLayout = styled.div`
  outline: 10px solid red;
  position: absolute;
  width: 100%;
  height: 100%;
`;
const PitchResult = styled.div`
  position: absolute;
  width: 400px;
  top: 30%;
  left: 50%;
  text-align: center;
  font-size: 3rem;
  font-weight: bold;
  color: white;
`;

const PitchButton = styled.div`
  position: absolute;
  top: 50%;
  left: 45%;
  width: 13rem;
  padding: 10px;
  border: 1px solid white;
  border-radius: 30px;
  text-align: center;
  font-size: 4rem;
  font-weight: bold;
  color: white;

  cursor: pointer;

  &:hover {
    transform: scale(1.1);
  }

  @media (max-width: 1200px) {
    width: 12rem;
    left: 41%;
    font-size: 2rem;
  }
  @media (max-width: 768px) {
    width: 8rem;
    left: 40%;
    font-size: 1rem;
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
