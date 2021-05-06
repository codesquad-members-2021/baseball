import React from "react";
import styled from "styled-components";

const PitchButton = () => {
  return (
    <>
      <PitchBtn>PITCH</PitchBtn>
    </>
  );
};

const PitchBtn = styled.button`
  position: absolute;
  left: 37%;
  top: 42%;
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
