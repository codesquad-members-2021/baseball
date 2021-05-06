import React, { useEffect, useRef } from "react";
import styled from "styled-components";

const BaseballField = () => {
  let canvasRef = useRef();
  let canvas;
  let ctx;
  useEffect(() => {
    canvas = canvasRef.current;
    ctx = canvas.getContext("2d");
    fitToContainer(canvas);
    drawField(ctx, canvas.offsetWidth, canvas.offsetHeight);
  }, []);

  const drawField = (ctx, x, y) => {
    ctx.strokeStyle = "white";
    ctx.lineWidth = "5";
    ctx.moveTo(350, 70);
    ctx.lineTo(100, 270);
    ctx.lineTo(350, 470);
    ctx.lineTo(600, 270);
    ctx.lineTo(350, 70);
    ctx.stroke();
    drawBase(ctx, 350, 70);
    drawBase(ctx, 100, 270);
    drawBase(ctx, 600, 270);
    drawHomeBase(ctx, 350, 470);
  };

  const drawBase = (ctx, x, y) => {
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

  function fitToContainer(canvas) {
    canvas.style.width = "100%";
    canvas.style.height = "100%";
    canvas.width = canvas.offsetWidth;
    canvas.height = canvas.offsetHeight;
  }

  return (
    <BaseballFieldWrapper>
      <canvas ref={canvasRef} />
    </BaseballFieldWrapper>
  );
};

const BaseballFieldWrapper = styled.div`
  color: white;
  width: 65%;
  height: 100%;
`;

export default BaseballField;
