<<<<<<< HEAD
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
=======
const base = {
  home: {
    x: 350,
    y: 470,
  },
  first: {
    x: 600,
    y: 270,
  },
  second: {
    x: 350,
    y: 70,
  },
  third: {
    x: 100,
    y: 270,
  },
};

const drawField = (ctx, x, y) => {
  ctx.strokeStyle = "white";
  ctx.lineWidth = "5";
  ctx.moveTo(base.second.x, base.second.y);
  ctx.lineTo(base.third.x, base.third.y);
  ctx.lineTo(base.home.x, base.home.y);
  ctx.lineTo(base.first.x, base.first.y);
  ctx.lineTo(base.second.x, base.second.y);
  ctx.stroke();
  drawBase(ctx, base.second.x, base.second.y);
  drawBase(ctx, base.third.x, base.third.y);
  drawBase(ctx, base.first.x, base.first.y);
  drawHomeBase(ctx, base.home.x, base.home.y);
>>>>>>> d7b33c2... Refactor. 캔버스 유틸 나누기
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
<<<<<<< HEAD
export { fitToContainer, drawHomeBase, drawBase, drawField };
=======

export { fitToContainer, drawHomeBase, base, drawBase, drawField };
>>>>>>> d7b33c2... Refactor. 캔버스 유틸 나누기
