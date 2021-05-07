const { createProxyMiddleware } = require("http-proxy-middleware");

const aws = {
  target: "http://ec2-15-165-205-188.ap-northeast-2.compute.amazonaws.com:8080",
  changeOrigin: true,
};

module.exports = function (app) {
  app.use("/", createProxyMiddleware(aws));

  app.use("/game/1/playerListPopup", createProxyMiddleware(aws));
};
