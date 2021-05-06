const drawField = (ctx, x, y) => {
  ctx.strokeStyle = "white";
  ctx.lineWidth = "5";
  ctx.moveTo(x / 2, y / 12);
  ctx.lineTo(x / 10, y / 2);
  ctx.lineTo(x / 2, y - y / 12);
  ctx.lineTo(x - x / 10, y / 2);
  ctx.lineTo(x / 2, y / 12);
  ctx.stroke();
  drawBase(ctx, x / 2, y / 12);
  drawBase(ctx, x / 10, y / 2);
  drawBase(ctx, x - x / 10, y / 2);
  drawHomeBase(ctx, x / 2, y - y / 12);
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

const drawHomeBase = (canvas, x, y) => {
  canvas.fillStyle = "white";
  canvas.beginPath();
  canvas.moveTo(x, y - 30);
  canvas.lineTo(x - 30, y);
  canvas.lineTo(x - 30, y + 50);
  canvas.lineTo(x + 30, y + 50);
  canvas.lineTo(x + 30, y);
  canvas.lineTo(x, y - 30);
  canvas.fill();
};

const fitToContainer = (canvas) => {
  canvas.style.width = "100%";
  canvas.style.height = "100%";
  canvas.width = canvas.offsetWidth;
  canvas.height = canvas.offsetHeight;
};
export { fitToContainer, drawHomeBase, drawBase, drawField };