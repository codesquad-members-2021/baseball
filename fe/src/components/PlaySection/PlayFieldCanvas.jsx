import { useRef, useEffect } from "react";

const drawField = (ctx, x, y) => {
  ctx.strokeStyle = "white";
  ctx.lineWidth = "5";
  ctx.moveTo(x / 2, y / 4);
  ctx.lineTo(x / 10, y / 2);
  ctx.lineTo(x / 2, y - y / 10);
  ctx.lineTo(x - x / 10, y / 2);
  ctx.lineTo(x / 2, y / 4);
  ctx.stroke();
};

const PlayFieldCanvas = () => {
  const canvasRef = useRef();

  useEffect(() => {
    const canvas = canvasRef.current;
    const ctx = canvas.getContext("2d");
    canvas.style.position = "absolute";
    canvas.style.width = "100%";
    canvas.style.height = "100%";
    canvas.width = canvas.offsetWidth;
    canvas.height = canvas.offsetHeight;
    drawField(ctx, canvas.offsetWidth, canvas.offsetHeight);
  }, []);

  return (
    <div>
      <canvas ref={canvasRef} />
    </div>
  );
};

export default PlayFieldCanvas;
