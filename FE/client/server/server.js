const express = require("express");
const app = express();
const port = 3001;  //포트 번호 3001
const http = require("http").createServer(app);
const io = require("socket.io")(http, {
  cors: { origin: '*' }
});

const baseball = {
  playerId: 0,
  playerCount: 0,
  roomNumber: 0,
  gameId: 0,
  playerList: []

}

io.on("connection", (socket) => {
  const connectPlayerId = ++baseball.playerId;
  socket.on('init', () => {
    console.log('init');
    socket.join('room1');
    socket.emit('playerId', connectPlayerId);
  });



  socket.on('choiceTeam', ({ playerId, gameId, teamName }) => {


    // io.to('room1').emit('selectedTeam', teamName);
    console.log(teamName)
  });

  socket.on('disconnect', () => {
    console.log(connectPlayerId)
    // socket.leave('room1'); //disconnect하면 자동으로 leave가 됨
    console.log('disconnected');
  });
});

http.listen(port, () => {
  console.log(`app listening on port : ${port}`);
});