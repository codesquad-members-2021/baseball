const express = require("express");
const app = express();
const port = 3001;  //포트 번호 3001
const http = require("http").createServer(app);
const io = require("socket.io")(http, {
  cors: { origin: '*' }
});
let id = 0;

io.on("connection", (socket) => {

  console.log('a user connected');

  socket.on('init', (data) => {
    id++;
    console.log(data.name);
    console.log(id)
    socket.emit('welcome', `hello! ${data.name}`);
  });

  socket.on('disconnect', () => {
    console.log('disconnected');
  });
});

http.listen(port, () => {
  console.log(`app listening on port : ${port}`);
});