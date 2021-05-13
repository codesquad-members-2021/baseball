const express = require("express");
const app = express();
const port = 3001; //포트 번호 3001
const http = require("http").createServer(app);
const io = require("socket.io")(http, {
  cors: { origin: "*" },
});

const baseball = {
  games: [],
  users: [],
};

const pitchState = [];

io.on("connection", (socket) => {
  const connectPlayerId = socket.id;
  socket.on("init", () => {
    console.log("init");
    socket.join("room1");
    baseball.users.push({ playerId: connectPlayerId, socket });
    socket.emit("selectedTeam", baseball.games);
  });

  socket.on("choiceTeam", ({ gameId, teamKind }) => {
    baseball.games = baseball.games.filter(
      ({ playerId }) => playerId !== connectPlayerId
    );

    const isMatchGame = baseball.games.some((game) => game.gameId === gameId);
    baseball.games.push({ playerId: connectPlayerId, gameId, teamKind });

    io.to("room1").emit("selectedTeam", baseball.games);

    if (isMatchGame) startGame({ gameId });
  });

  socket.on("pitchClicked", (msg) => {
    console.log(msg);
    io.to("room1").emit("pitchResult", randomPitch());
  });

  socket.on("disconnect", () => {
    baseball.games = baseball.games.filter(
      ({ playerId }) => playerId !== connectPlayerId
    );
    baseball.users = baseball.users.filter(
      ({ playerId }) => playerId !== connectPlayerId
    );
    // socket.leave('room1'); //disconnect하면 자동으로 leave가 됨
    console.log("disconnected");
  });
});

http.listen(port, () => {
  console.log(`app listening on port : ${port}`);
});

function startGame({ gameId }) {
  const matchTeams = baseball.games.filter((game) => game.gameId === gameId);
  const matchUsers = baseball.users.filter((user) =>
    matchTeams.find((matchTeam) => {
      return user.playerId === matchTeam.playerId;
    })
  );

  const matchCombinedData = matchUsers.map((user) => ({
    ...matchTeams.find((game) => {
      return user.playerId === game.playerId;
    }),
    ...user,
  }));

  matchCombinedData.forEach((user) => {
    user.socket.emit("matchingGame", {
      gamePageUrl: "/GamePage",
      gameId: user.gameId,
      teamKind: user.teamKind,
    });
  });
}

const randomPitch = () => {
  const arr = ["strike", "ball", "hit"];
  return arr[Math.floor(Math.random() * arr.length)];
};
