import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import styled from "styled-components";

const PitchButton = () => {
  const { onPitch } = useContext(GamePageContext);
  return (
    <>
      <PitchBtn onClick={onPitch}>PITCH</PitchBtn>
    </>
  );
};

const PitchBtn = styled.button`
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  background: none;
  color: white;
  font-size: 1.5rem;
  border: 0.1rem solid white;
  border-radius: 10px;
  padding: 1rem 2rem;
  cursor: pointer;
  &:hover {
    color: black;
    background: white;
  }
`;

export default PitchButton;