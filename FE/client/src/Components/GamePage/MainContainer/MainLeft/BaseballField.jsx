import React, { useEffect, useRef } from "react";
import styled from "styled-components";
import { fitToContainer, drawField } from "utils/canvasUtils";
import PitchButton from "Components/GamePage/MainContainer/MainLeft/PitchButton";

const BaseballField = () => {
  let canvasRef = useRef();
  useEffect(() => {
    let canvas = canvasRef.current;
    let ctx = canvas.getContext("2d");
    fitToContainer(canvas);
    drawField(ctx, canvas.offsetWidth, canvas.offsetHeight);
  }, []);

  return (
    <BaseballFieldWrapper>
      <canvas ref={canvasRef} />
      <PitchButton />
    </BaseballFieldWrapper>
  );
};

const BaseballFieldWrapper = styled.div`
  color: white;
  width: 65%;
  height: 100%;
  position: relative;
`;

export default BaseballField;
