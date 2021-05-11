const express = require("express");
const app = express();
const port = 3001;  //포트 번호 3001
const http = require("http").createServer(app);
const io = require("socket.io")(http, {
  cors: { origin: '*' }
});

const baseball = {
  games: [],
}

io.on("connection", (socket) => {
  const connectPlayerId = socket.id;
  socket.on('init', () => {
    console.log('init');
    socket.join('room1');
    socket.emit('selectedTeam', baseball.games);
  });

  socket.on('choiceTeam', ({ gameId, teamKind }) => {
    baseball.games = baseball.games.filter(({ playerId }) => playerId !== connectPlayerId);
    baseball.games.push({ playerId: connectPlayerId, gameId, teamKind });
    console.log(baseball.games)
    io.to('room1').emit('selectedTeam', baseball.games);
  });

  socket.on('disconnect', () => {
    baseball.games = baseball.games.filter(({ playerId }) => playerId !== connectPlayerId);
    // socket.leave('room1'); //disconnect하면 자동으로 leave가 됨
    console.log('disconnected');
  });
});

http.listen(port, () => {
  console.log(`app listening on port : ${port}`);
});