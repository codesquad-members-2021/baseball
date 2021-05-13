import React, { useContext, useEffect, useMemo, useRef, useState } from "react";
import styled from "styled-components";
import { fitToContainer, drawField } from "utils/canvasUtils";
import RunnerImage from "./RunnerImage";
import PitchButton from "./PitchButton";
import { GamePageContext } from "Components/GamePage";
import ReadyImage from "./ReadyImage";

const BaseballField = () => {
  const { teamState, attackState, currentBaseData } = useContext(GamePageContext);
  const canvasRef = useRef();
  const baseCount = useRef(0); //이전 base의 length가 뭐였는지 저장하기위함
  const key = useRef(0);

  // const getKey = () => ++key.current;

  useEffect(() => {
    const canvas = canvasRef.current;
    const ctx = canvas.getContext("2d");
    fitToContainer(canvas);
    drawField(ctx, canvas.offsetWidth, canvas.offsetHeight);
  }, []);

  useEffect(() => {
    ++key.current;
    baseCount.current += 1;
  }, [currentBaseData]);

  const numberEng = {
    0: 'first',
    1: 'second',
    2: 'third'
  };

  return (
    <BaseballFieldWrapper>
      <canvas ref={canvasRef} />

      {currentBaseData.map((_, index) => {
        return (<>
          <RunnerImage base={numberEng[index]} key={index} />
          <ReadyImage base={numberEng[index]} key={index} />
        </>)
      })}
      {baseCount.current > 4 && <RunnerImage base='fourth' />}
      {/* <RunnerImage base='first' />
      <RunnerImage base='second' />
      <RunnerImage base='third' />
      <RunnerImage base='fourth' />
      <ReadyImage base='first' />
      <ReadyImage base='second' />
      <ReadyImage base='third' /> */}
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
