import React, { useContext, useEffect, useRef } from "react";
import styled from "styled-components";
import { fitToContainer, drawField } from "utils/canvasUtils";
import RunnerImage from "./RunnerImage";
import PitchButton from "./PitchButton";
import { GamePageContext } from "Components/GamePage";
import ReadyImage from "./ReadyImage";

const BaseballField = () => {
  const { teamState, attackState } = useContext(GamePageContext);
  const canvasRef = useRef();

  useEffect(() => {
    const canvas = canvasRef.current;
    const ctx = canvas.getContext("2d");
    fitToContainer(canvas);
    drawField(ctx, canvas.offsetWidth, canvas.offsetHeight);
  }, []);

  return (
    <BaseballFieldWrapper>
      <canvas ref={canvasRef} />
      <RunnerImage base='first' />
      <RunnerImage base='second' />
      <RunnerImage base='third' />
      <RunnerImage base='fourth' />
      <ReadyImage base='first' />
      <ReadyImage base='second' />
      <ReadyImage base='third' />
      <PitchButton />
    </BaseballFieldWrapper>
  );
};

const BaseballFieldWrapper = styled.div`
  position: relative;
  color: white;
  width: 65%;
  height: 100%;
`;

export default BaseballField;
