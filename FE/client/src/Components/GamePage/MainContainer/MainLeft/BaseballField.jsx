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

  useEffect(() => {
    const canvas = canvasRef.current;
    const ctx = canvas.getContext("2d");
    fitToContainer(canvas);
    drawField(ctx, canvas.offsetWidth, canvas.offsetHeight);
  }, []);

  useEffect(() => {
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

      {currentBaseData.map((base, index) => {
        return (<q key={base.name + base.id + index}>
          <RunnerImage base={numberEng[index]} />
          <ReadyImage base={numberEng[index]} />
        </q>)
      })}
      {baseCount.current > 4 && <RunnerImage base='fourth' key={baseCount.current} />}

      {!teamState[attackState].isMyTeam && <PitchButton />}
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
