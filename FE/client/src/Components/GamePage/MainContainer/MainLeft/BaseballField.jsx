import React, { useEffect, useRef } from "react";
import styled from "styled-components";

const BaseballField = () => {
  let canvasRef = useRef();
  let canvas;
  let ctx;
  useEffect(() => {
    canvas = canvasRef.current;
    ctx = canvas.getContext("2d");
    drawField(ctx);
  }, []);

  const drawField = (ctx) => {
    ctx.strokeStyle = "white";
    ctx.lineWidth = "5";
    ctx.moveTo(300, 70);
    ctx.lineTo(50, 270);
    ctx.lineTo(300, 470);
    ctx.lineTo(550, 270);
    ctx.lineTo(300, 70);
    ctx.stroke();
    drawBase(ctx, 300, 70);
    drawBase(ctx, 50, 270);
    drawBase(ctx, 550, 270);
    drawHomeBase(ctx, 300, 470);
  };

  const drawBase = (ctx, x, y) => {
    //
    ctx.fillStyle = "white";
    ctx.beginPath();
    ctx.moveTo(x, y - 30);
    ctx.lineTo(x - 30, y);
    ctx.lineTo(x, y + 30);
    ctx.lineTo(x + 30, y);
    ctx.lineTo(x, y - 30);
    ctx.fill();
  };

  const drawHomeBase = (ctx, x, y) => {
    ctx.fillStyle = "white";
    ctx.beginPath();
    ctx.moveTo(x, y - 30);
    ctx.lineTo(x - 30, y);
    ctx.lineTo(x - 30, y + 50);
    ctx.lineTo(x + 30, y + 50);
    ctx.lineTo(x + 30, y);
    ctx.lineTo(x, y - 30);
    ctx.fill();
  };

  return (
    <BaseballFieldWrapper>
      <canvas ref={canvasRef} width={"600"} height={"540"} />
    </BaseballFieldWrapper>
  );
};

const BaseballFieldWrapper = styled.div`
  color: white;
  padding: 2rem;
`;

export default BaseballField;
